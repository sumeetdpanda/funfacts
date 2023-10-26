package com.thetechbears.funfacts.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thetechbears.funfacts.R
import com.thetechbears.funfacts.data.UserDataUiEvents
import com.thetechbears.funfacts.ui.AnimalCard
import com.thetechbears.funfacts.ui.ButtonComponent
import com.thetechbears.funfacts.ui.TextComponent
import com.thetechbears.funfacts.ui.TextFieldComponent
import com.thetechbears.funfacts.ui.TopBar
import com.thetechbears.funfacts.ui.UserInputViewModel

@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel, showWelcomeScreen: (valuesPair: Pair<String, String>) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar("Hi there \uD83D\uDE0A")

            TextComponent(
                textValue ="Let's learn about You !",
                textSize = 24.sp,
            )

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "This app will prepare details page based on input provided by you !",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            TextComponent(textValue = "Name", textSize = 18.sp)

            Spacer(modifier = Modifier.size(10.dp))

            TextFieldComponent(onTextChange = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEntered(it)
                )
            })

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "What do you like", textSize = 18.sp)

            Row(modifier = Modifier.fillMaxWidth()) {
                AnimalCard(image = R.drawable.ic_cat, animalSelected = {
                    userInputViewModel.onEvent(UserDataUiEvents.AnimalSelected(it))
                }, selected = userInputViewModel.uiState.value.animalSelected == "Cat")

                AnimalCard(image = R.drawable.ic_dog, animalSelected = {
                    userInputViewModel.onEvent(UserDataUiEvents.AnimalSelected(it))
                }, selected = userInputViewModel.uiState.value.animalSelected == "Dog")
            }
            
            Spacer(modifier = Modifier.weight(1f))

            if(userInputViewModel.isValidState())
            {
                ButtonComponent(
                    goToDetailsScreen = {
                        Pair(
                            userInputViewModel.uiState.value.nameEntered,
                            userInputViewModel.uiState.value.animalSelected
                        )
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(UserInputViewModel(), showWelcomeScreen = {})
}