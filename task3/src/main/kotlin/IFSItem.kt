import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayDeque

interface IFSItem {
    val name: String
    val size: Long
    val date: LocalDateTime
}

open class Directory(
    override val name: String,
    vararg children: IFSItem
) : IFSItem {
    private val children = arrayListOf(*children)
    override val date: LocalDateTime = LocalDateTime.now()
    override val size: Long
        get() = children.sumOf { x -> x.size }

    fun add(vararg items: IFSItem) {
        for (item in items) {
            children.add(item)
        }
        children.sortBy { item -> item.name }
    }

    fun list() {
        children.forEach { item -> println("${item.name} ${item.date.second}") }
    }

    fun get(name: String) = children.find { item -> item.name == name }
    fun remove(name: String) = children.removeIf { item -> item.name == name }
}

class File(override val name: String, override val size: Long) : IFSItem {
    override val date: LocalDateTime = LocalDateTime.now()
}

object Root : Directory("")

object Caret {
    private val stack = Stack<Directory>()
    private var current: Directory = Root

    private fun changeDir(name: String) {
        when (name) {
            ".." -> current = stack.removeLastOrNull() ?: current
            else -> {
                val next = current.get(name)
                if (next is Directory) {
                    stack.push(current)
                    current = next
                }
            }
        }
    }

    private fun list() = current.list()
    private fun diskUsage() = println(current.size)
    private fun remove(name: String) = current.remove(name)

    private fun makeDir(name: String) = current.add(Directory(name))

    private fun makeFile(nameAndSize: String) {
        val name = nameAndSize.substringBefore(' ')
        val size = nameAndSize.substringAfter(' ').toLong()
        current.add(File(name, size))
    }

    private fun status() {
        stack.forEach { item -> print("${item.name}/") }
        println("${current.name}/")
        print("> ")
    }

    private fun parceCommand(command: String) {
        when (command) {
            "ls" -> list()
            "du" -> diskUsage()
            else -> {
                val prefix = command.substringBefore(' ')
                val suffix = command.substringAfter(' ')
                when (prefix) {
                    "cd" -> {
                        if (suffix.startsWith("/")) {
                            current = Root
                            stack.clear()
                        }
                        val path = suffix.split('/')
                        for (dir in path) {
                            changeDir(dir)
                        }
                    }
                    "rm" -> remove(suffix)
                    "mkdir" -> makeDir(suffix)
                    "file" -> makeFile(suffix)
                    else -> {}
                }
            }
        }
    }

    fun loop() {
        while (true) {
            status()
            val command = readLine()
            if (command == null || command == "exit") {
                break
            } else {
                parceCommand(command)
            }
        }
    }
}