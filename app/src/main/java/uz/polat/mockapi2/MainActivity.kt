package uz.polat.mockapi2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import uz.polat.mockapi2.ui.theme.MockApi2Theme

class MainActivity : ComponentActivity() {
    private val viewModel by lazy { ViewModelProvider(this)[MainVM::class] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MockApi2Theme {
                Greeting(viewModel)
            }
        }
    }
}

@Composable
fun Greeting(viewModel: MainVM) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (viewModel.post.value != null) {
            Text(
                text = viewModel.post.value!!.title,
            )
        }

        Button(onClick = {
            viewModel.getPost1()
        }) {
            Text(text = "Get post1")
        }

        Button(onClick = {
            viewModel.getPost2()
        }) {
            Text(text = "Get post2")
        }

        Button(onClick = {
            viewModel.getPost3()
        }) {
            Text(text = "Get post3")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MockApi2Theme {
        Greeting(MainVM())
    }
}