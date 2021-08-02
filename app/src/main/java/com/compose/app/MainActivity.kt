package com.compose.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.compose.app.ui.theme.ComposeAppTheme

@ExperimentalUnitApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting(name = "JetPack Compose")
            NewsStory()
        }

    }

    //定义可组合函数 一个可组合函数必须在另一个可组合函数中调用
    @Composable
    fun Greeting(name: String){
        Text(text = "Hello $name")
    }

    //创建预览函数、预览函数不能带有参数 且必须使用 @Preview 注解修饰
    @Preview
    @Composable
    fun PreviewGreeting(){
        Greeting(name = "preview Greeting")
    }


    @Composable
    fun NewsStory(){
        //Column 可以垂直堆放元素
        Column(Modifier.padding(10.dp)) {

            //contentScale 指定图片应填充 Column 的整个宽度，并根据需要剪裁为适当的高度。
            Image(painter = painterResource(id = R.drawable.ic_sea), contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth(1.0f)
                    .clip(shape = RoundedCornerShape(5.dp)), //圆角化
            contentScale = ContentScale.Crop)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "BBC News Story",color = Color.White,
                fontSize = TextUnit(20f, TextUnitType.Sp),
                style = typography.h6 //Material Design 风格
            )

            Text(text = "CNN TOP News Story", color = Color.Red,
                style = typography.body1
            )
            Text(text = "CCTV TOP News Story", fontStyle = FontStyle.Italic,
                style = typography.body2
            )
        }
    }

    @Preview
    @Composable
    fun PreviewNewsStory(){
        NewsStory()
    }
}
