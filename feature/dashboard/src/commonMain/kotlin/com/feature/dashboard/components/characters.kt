package com.feature.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.resources.CaballeroItsu
import com.resources.CaballeroItsu2
import com.resources.DragonLogico
import com.resources.DragonRunas
import com.resources.HechizeraProgramadora
import com.resources.PequeñaAprendizBecaria
import com.resources.Res
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun Characters() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        content = {
            items(Character.entries.toTypedArray()) { character ->
                CharacterItem(character = character)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    )
}

@Composable
internal fun CharacterItem(
    character: Character,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier.size(
            width = 70.dp,
            height = 100.dp
        ),
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(character.character),
                    contentDescription = "Settings",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape),
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = character.nameText,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 16.sp,
                )
            }
        }
    )
}

enum class Character(val character: DrawableResource, val nameText: String) {
    PEUENA_APRENDIZ(character = Res.drawable.PequeñaAprendizBecaria, "Becaria"),
    HECHIZERA_PROGRAMADORA(
        character = Res.drawable.HechizeraProgramadora,
        "Hechicera"
    ),
    CABALLERO_ITSU_1(character = Res.drawable.CaballeroItsu, nameText = "Caballero Itsu"),
    CABALLERO_ITSU_2(character = Res.drawable.CaballeroItsu2, nameText = "Caballero Itsu"),
    DRAGON_RUNICO(character = Res.drawable.DragonRunas, nameText = "Dragon Runico"),
    DRAGON_LOGICO(character = Res.drawable.DragonLogico, nameText = "Dragon Logico")
}