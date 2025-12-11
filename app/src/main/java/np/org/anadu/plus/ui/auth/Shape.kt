package np.org.anadu.plus.ui.auth

import androidx.compose.foundation.shape.GenericShape

val SinusoidalBottomShape = GenericShape { size, _ ->
    moveTo(0f, 0f)
    lineTo(size.width, 0f)
    lineTo(size.width, size.height * 0.75f)

    cubicTo(
        size.width * 0.75f, size.height,
        size.width * 0.25f, size.height * 0.5f,
        0f, size.height * 0.8f
    )

    lineTo(0f, 0f)
}