
fun main() {
    Root.add(
        Directory(
            "docs",
            File("Gauss_method.pdf", 500),
            File("lab1report.pdf", 30),
            Directory(
                "hw",
                File("math.mp4", 699999)
            )
        ),
        Directory(
                "pics",
            File("wallpaper.jpg", 1024)
        ),
    )
    Caret.loop()
}