package com.example.botton_debug

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.botton_debug.ui.theme.Botton_DebugTheme
import com.example.botton_debug.ui.theme.DebugButtonCollors
import com.example.botton_debug.ui.theme.ErrorButtonCollors
import com.example.botton_debug.ui.theme.InfoButtonCollors
import com.example.botton_debug.ui.theme.SendButtonCollors
import com.example.botton_debug.ui.theme.SuccessButtonCollors
import com.example.botton_debug.ui.theme.WarningButtonCollors
import com.example.botton_debug.ui.theme.darkBlue
import com.example.botton_debug.ui.theme.darkCian
import com.example.botton_debug.ui.theme.darkGreen
import com.example.botton_debug.ui.theme.darkPink
import com.example.botton_debug.ui.theme.darkRed
import com.example.botton_debug.ui.theme.success
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Botton_DebugTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}


@Composable
fun ActionButton(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    block: () -> Unit,
) {
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            tint = Color.White,
            contentDescription = "Executar",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = text, color = Color.White, fontSize = 16.sp)
    }
}

@Composable
private fun BotaoImagemText() {
    Text(
        text = "Botões e Imagem",
        color = Color(0xFFd14334),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(7.dp)
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}

@Composable
fun animation() {
    var expanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Card(
            modifier = Modifier
                .clickable {
                    expanded = !expanded
                    Log.d(TAG, "App: Card clicado. expanded=$expanded")
                }
                .padding(5.dp),

            )

        {
            Column(
                modifier = Modifier.background(Color(0xFFFFFCF3)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(200.dp),
                    painter = painterResource(id = R.drawable.ic_jetpack_compose_logo),
                    contentDescription = null
                )
                AnimatedVisibility(expanded) {
                    Column(
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Row(
                            modifier = Modifier
                        ) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp),
                                tint = Color(0xFFd14334)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Bruno Portugal",
                                style = MaterialTheme.typography.bodyLarge,
                                textAlign = TextAlign.Left
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier
                        ) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp),
                                tint = Color(0xFFd14334)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "RM: 22295",
                                style = MaterialTheme.typography.bodyLarge,
                                textAlign = TextAlign.Left
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier
                        ) {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp),
                                tint = Color(0xFFd14334)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "ETEC Zona Leste",
                                style = MaterialTheme.typography.bodyLarge,
                                textAlign = TextAlign.Left
                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun App() {
    var isErrorClicked by remember { mutableStateOf(false) }
    var isSuccesClicked by remember { mutableStateOf(false) }
    var isSendClicked by remember { mutableStateOf(false) }
    var isWarnigClicked by remember { mutableStateOf(false) }
    var isInfoClicked by remember { mutableStateOf(false) }
    var isDebugClicked by remember { mutableStateOf(false) }



    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color(0xFFd14334), title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "Localized description",
                    tint = Color(0xFFEDF2FA),
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "Jetpack Compose",
                    fontSize = 16.sp,
                    color = Color(0xFFEDF2FA),
                    fontWeight = FontWeight.Bold
                )
            }
        })
    }, bottomBar = {
        BottomAppBar(
            backgroundColor = Color(0xFFd14334), cutoutShape = CircleShape
        ) {
            Text(
                text = "Desenvolvido por Bruno Portugal",
                color = Color(0xFFEDF2FA),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
        }
    }, modifier = Modifier
        .navigationBarsPadding()
        .imePadding()
        .statusBarsPadding()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFFFFFCF3), Color(0xFFFFFCF3))
                    )
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                BotaoImagemText()
                animation()

                Spacer(modifier = Modifier.height(10.dp))

                Card(
                    modifier = Modifier
                        .size(width = 450.dp, height = 300.dp)
                        .padding(top = 16.dp),
                    elevation = 1.dp
                ) {
                    Column(
                        modifier = Modifier.background(Color(0xFFFFFCF3)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            ActionButton(
                                text = "Debugação",
                                icon = Icons.Filled.Build,
                                buttonColors = DebugButtonCollors(),
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(8.dp)
                            ) {
                                isDebugClicked = true
                                //   Toast.makeText(context, "Clicou em DEBUG!", Toast.LENGTH_SHORT).show()
                                Log.d(TAG, "App: Você clicou em DEBUG...")
                            }
                            ActionButton(
                                text = "Informação",
                                icon = Icons.Filled.Info,
                                buttonColors = InfoButtonCollors(),
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(8.dp)
                            ) {
                                isInfoClicked = true
                                // Toast.makeText(context, "Clicou em INFO!", Toast.LENGTH_SHORT).show()
                                Log.i(TAG, "App: Você clicou em INFO...")
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            ActionButton(
                                text = "Aviso",
                                icon = Icons.Filled.Warning,
                                buttonColors = WarningButtonCollors(),
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(8.dp)
                            ) {
                                isWarnigClicked = true
                                // Toast.makeText(context, "Clicou em WARNING!", Toast.LENGTH_SHORT).show()
                                Log.w(TAG, "App: Você clicou em WARNING...")
                            }
                            ActionButton(
                                text = "Enviar",
                                icon = Icons.Filled.Send,
                                buttonColors = SendButtonCollors(),
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(8.dp)
                            ) {
                                isSendClicked = true
                                //  Toast.makeText(context, "Clicou em Send!", Toast.LENGTH_SHORT).show()
                                Log.w(TAG, "App: Você clicou em Send...")
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            ActionButton(
                                text = "Sucesso",
                                icon = Icons.Filled.Check,
                                buttonColors = SuccessButtonCollors(),
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(8.dp)
                            ) {
                                isSuccesClicked = true
                                Log.d(TAG, "App: Você clicou em SUCCESS...")
                            }
                            ActionButton(
                                text = "Erro",
                                icon = Icons.Filled.Close,
                                buttonColors = ErrorButtonCollors(),
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(8.dp)
                            ) {
                                isErrorClicked = true

                                Log.e(TAG, "App: Você clicou em ERROR...")
                            }

                        }
                        Card(
                            modifier = Modifier
                                .size(width = 450.dp, height = 300.dp)
                                .padding(5.dp),
                        ) {
                            Column(
                                modifier = Modifier.background(Color(0xFFF8F2E1)),
                            ) {
                                AnimatedVisibility(
                                    visible = isErrorClicked, // Controla a visibilidade da tela de erro
                                    enter = fadeIn(), exit = fadeOut()
                                ) {
                                    // Conteúdo da tela de erro
                                    Text(
                                        text = "Ocorreu um erro!",
                                        fontSize = 20.sp,
                                        color = darkRed,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier
                                            .padding(16.dp)
                                            .fillMaxWidth()
                                            .wrapContentWidth(Alignment.CenterHorizontally)
                                    )
                                }
                                AnimatedVisibility(
                                    visible = isSuccesClicked, // Controla a visibilidade da tela de erro
                                    enter = fadeIn(), exit = fadeOut()
                                ) {
                                    // Conteúdo da tela de erro
                                    Text(
                                        text = "Concluído com Sucesso!",
                                        fontSize = 20.sp,
                                        color = success,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier
                                            .padding(16.dp)
                                            .fillMaxWidth()
                                            .wrapContentWidth(Alignment.CenterHorizontally)
                                    )
                                }
                                AnimatedVisibility(
                                    visible = isSendClicked, // Controla a visibilidade da tela de erro
                                    enter = fadeIn(), exit = fadeOut()
                                ) {
                                    // Conteúdo da tela de erro
                                    Text(
                                        text = "Mensagem Enviada",
                                        fontSize = 20.sp,
                                        color = darkCian,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier
                                            .padding(16.dp)
                                            .fillMaxWidth()
                                            .wrapContentWidth(Alignment.CenterHorizontally)
                                    )
                                }
                                AnimatedVisibility(
                                    visible = isInfoClicked, // Controla a visibilidade da tela de erro
                                    enter = fadeIn(), exit = fadeOut()
                                ) {
                                    // Conteúdo da tela de erro
                                    Text(
                                        text = "Informações Obtidas",
                                        fontSize = 20.sp,
                                        color = darkBlue,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier
                                            .padding(16.dp)
                                            .fillMaxWidth()
                                            .wrapContentWidth(Alignment.CenterHorizontally)
                                    )
                                }
                                AnimatedVisibility(
                                    visible = isDebugClicked, // Controla a visibilidade da tela de erro
                                    enter = fadeIn(), exit = fadeOut()
                                ) {
                                    // Conteúdo da tela de erro
                                    Text(
                                        text = "Debugação",
                                        fontSize = 20.sp,
                                        color = darkGreen,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier
                                            .padding(16.dp)
                                            .fillMaxWidth()
                                            .wrapContentWidth(Alignment.CenterHorizontally)
                                    )
                                }
                                AnimatedVisibility(
                                    visible = isWarnigClicked, // Controla a visibilidade da tela de erro
                                    enter = fadeIn(), exit = fadeOut()
                                ) {
                                    // Conteúdo da tela de erro
                                    Text(
                                        text = "Aviso!!!",
                                        fontSize = 20.sp,
                                        color = darkPink,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier
                                            .padding(16.dp)
                                            .fillMaxWidth()
                                            .wrapContentWidth(Alignment.CenterHorizontally)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        LaunchedEffect(
            isErrorClicked,
            isSuccesClicked,
            isSendClicked,
            isDebugClicked,
            isInfoClicked,
            isWarnigClicked
        ) {
            if (isErrorClicked) {
                delay(1000) // Tempo em milissegundos para a tela de erro ficar visível
                isErrorClicked =
                    false // Define a variável isErrorClicked como false para esconder a tela de erro
            } else if (isSuccesClicked) {
                delay(1000) // Tempo em milissegundos para a tela de erro ficar visível
                isSuccesClicked = false
            } else if (isSendClicked) {
                delay(1000) // Tempo em milissegundos para a tela de erro ficar visível
                isSendClicked = false
            } else if (isDebugClicked) {
                delay(1000) // Tempo em milissegundos para a tela de erro ficar visível
                isDebugClicked = false
            } else if (isInfoClicked) {
                delay(1000) // Tempo em milissegundos para a tela de erro ficar visível
                isInfoClicked = false
            } else if (isWarnigClicked) {
                delay(1000) // Tempo em milissegundos para a tela de erro ficar visível
                isWarnigClicked = false
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun AppPreview() {
    Botton_DebugTheme {
        App()
    }
}
