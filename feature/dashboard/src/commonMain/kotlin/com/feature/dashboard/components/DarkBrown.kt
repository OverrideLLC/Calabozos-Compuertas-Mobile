package com.feature.dashboard.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import kotlin.random.Random

// Define some colors inspired by the image
val DarkBrown = Color(0xFF3A2D27)
val ShelfBrown = Color(0xFF5C4033)
val DarkBackground = Color(0xff000000) // A very dark color for the deep background
val BookColors = listOf(
    Color(0xFF8B4513), // SaddleBrown
    Color(0xFF4B0082), // Indigo
    Color(0xFF2E8B57), // SeaGreen
    Color(0xFF4682B4), // SteelBlue
    Color(0xFFA0522D), // Sienna
    Color(0xFF556B2F), // DarkOliveGreen
    Color(0xFF708090), // SlateGray
    Color(0xFF6A5ACD), // SlateBlue
    Color(0xFF800000)  // Maroon
)

/**
 * A Composable function that draws a library background on a Canvas.
 * Inspired by a dark library setting with bookshelves.
 */
@Composable
fun LibraryBackground(modifier: Modifier = Modifier) {
    // Use Canvas to draw custom graphics
    Canvas(modifier = modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val random = Random(123) // Seeded random for consistent results

        // Draw the deep dark background first
        drawRect(color = DarkBackground)

        // --- Bookshelf Structure ---
        val shelfCount = 5 // Number of horizontal shelves
        val verticalDividerCount = 4 // Number of vertical dividers
        val shelfHeight = canvasHeight / shelfCount
        val sectionWidth = canvasWidth / verticalDividerCount

        // Draw vertical dividers
        for (i in 1 until verticalDividerCount) {
            val x = i * sectionWidth
            drawRect(
                color = DarkBrown,
                topLeft = Offset(x - 5f, 0f), // Make dividers slightly thick
                size = Size(10f, canvasHeight)
            )
        }

        // Draw horizontal shelves and books on them
        for (shelfIndex in 0 until shelfCount) {
            val shelfY = (shelfIndex + 1) * shelfHeight

            // Draw the horizontal shelf board
            drawRect(
                color = ShelfBrown,
                topLeft = Offset(0f, shelfY - 8f), // Make shelves slightly thick
                size = Size(canvasWidth, 16f)
            )

            // --- Draw Books on this shelf ---
            for (sectionIndex in 0 until verticalDividerCount) {
                val sectionStartX = sectionIndex * sectionWidth
                val sectionEndX = (sectionIndex + 1) * sectionWidth
                drawBooksInSection(
                    drawScope = this,
                    random = random,
                    shelfTopY = shelfIndex * shelfHeight,
                    shelfBottomY = shelfY - 8f, // Position books above the shelf board
                    sectionStartX = sectionStartX + 10f, // Add padding from dividers
                    sectionEndX = sectionEndX - 10f, // Add padding from dividers
                    shelfHeight = shelfHeight
                )
            }
        }
    }
}

/**
 * Helper function to draw books within a specific section of a shelf.
 */
private fun drawBooksInSection(
    drawScope: DrawScope,
    random: Random,
    shelfTopY: Float,
    shelfBottomY: Float,
    sectionStartX: Float,
    sectionEndX: Float,
    shelfHeight: Float
) {
    val availableWidth = sectionEndX - sectionStartX
    var currentX = sectionStartX
    val bookBottomMargin = 10f // Space below books
    val bookTopMargin = 15f    // Space above books (variable height)

    // Draw books until the section width is filled
    while (currentX < sectionEndX - 10) { // Ensure minimum book width
        // Randomize book properties
        val bookWidth = random.nextFloat() * (availableWidth / 8) + 15f // Min width 15f
        if (currentX + bookWidth > sectionEndX) break // Stop if book exceeds section

        val bookHeightMultiplier = random.nextFloat() * 0.2f + 0.75f // Height variation (75% to 95%)
        val bookHeight = (shelfHeight - bookBottomMargin - bookTopMargin) * bookHeightMultiplier
        val bookTopY = shelfBottomY - bookHeight - bookBottomMargin
        val bookColor = BookColors.random(random)

        // Draw the book rectangle
        drawScope.drawRect(
            color = bookColor,
            topLeft = Offset(currentX, bookTopY),
            size = Size(bookWidth, bookHeight)
        )

        // Add a slight dark line for separation (optional)
        drawScope.drawLine(
            color = Color.Black.copy(alpha = 0.4f),
            start = Offset(currentX + bookWidth, bookTopY),
            end = Offset(currentX + bookWidth, shelfBottomY - bookBottomMargin),
            strokeWidth = 1.5f
        )

        currentX += bookWidth + random.nextFloat() * 3f // Add small random gap between books
    }
}

// --- Example Usage (in your main Composable) ---
/*
@Composable
fun MyApp() {
    MaterialTheme { // Or your app's theme
        Surface(modifier = Modifier.fillMaxSize()) {
            LibraryBackground()
            // Add other UI elements on top if needed
        }
    }
}
*/
