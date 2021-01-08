import kotlinx.browser.document

external fun require(o: String)


fun main() {
    require("css/main.sass")
    document.write("Hello, world!")
}