import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.lalilu.ldownloader.initKoin

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "ldownloader") {
        initKoin()
        App()
    }
}