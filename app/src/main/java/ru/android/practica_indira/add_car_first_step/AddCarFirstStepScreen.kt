package ru.android.practica_indira.add_car_first_step


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Preview
@Composable
fun AddCarFirstStepScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.padding(top = 113.dp),
                title = { Text(text = "Добавить авто",
                    fontSize = 36.sp,
                    fontWeight = FontWeight(700),
                    ) }
            )
        },
    ) {innerPadding ->
        LazyColumn(contentPadding = PaddingValues(
            top = innerPadding.calculateTopPadding(),
            bottom = innerPadding.calculateBottomPadding()
            ),
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Text(text = "Данные вашего автомобиля",
                        fontSize = 15.sp,
                        color = Color(0xCC1C1939),
                        textAlign = TextAlign.Center
                        )
                    Text(text = "Шаг 1/2",
                        fontSize = 15.sp,
                        color = Color(0xCC1C1939),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 12.dp)
                    )
                }
            }
            item { 
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(horizontal = 37.dp)
                    ) {
                    AddCarMenu(
                        menuName = "Марка автомобиля", 
                        modifier = Modifier.padding(top = 48.dp)
                    )
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(top = 4.dp)
                    ) {
                        AddCarMenu(menuName = "Модель", Modifier.weight(5f))
                        Spacer(modifier = Modifier.padding(4.dp))
                        AddCarMenu(menuName = "Год", Modifier.weight(2f))
                    }
                    AddCarMenu(
                        menuName = "Мощность двигателя",
                        modifier = Modifier.padding(top = 16.dp)
                        )
                    AddCarMenu(
                        menuName = "Объём двигателя",
                        modifier = Modifier.padding(top = 4.dp))
                    AddCarMenu(
                        menuName = "Топливо",
                        modifier = Modifier.padding(top = 4.dp))
                    AddCarMenu(
                        menuName = "КПП",
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    AddCarMenu(
                        menuName = "Привод",
                        modifier = Modifier.padding(top = 4.dp))

                }
            }
            item { 
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(horizontal = 37.dp)
                        .padding(top = 50.dp),
                    shape = MaterialTheme.shapes.extraSmall
                ) {
                    Text(
                        text = "Далее",
                        modifier = Modifier
                            .padding(horizontal = 100.dp, vertical = 10.dp)
                    )
                }
            }

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCarMenu(
    menuName: String,
    modifier: Modifier = Modifier
    /*dropDownItems: List<DropDownItem>,
    onItemClick: (DropDownItem) -> Unit*/
) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    var item by remember {
        mutableStateOf("")
    }
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = it }
        ) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFFF7F7F7),
                shape = MaterialTheme.shapes.extraSmall
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = item.takeIf {
                            it.isNotEmpty()
                        } ?: menuName,

                        modifier = Modifier
                            .padding(16.dp)
                            .menuAnchor()
                    )
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null,)
                }

            }
            /*TextField(
                value = item,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor(),
                placeholder = { Text(text = menuName)}
            )*/
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                DropdownMenuItem(text = { /*TODO*/ }, onClick = { /*TODO*/ })
            }
        }
    }

}
