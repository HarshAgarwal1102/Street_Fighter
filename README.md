# Street_Fighter
![wallpaperflare com_wallpaper (2)](https://github.com/king4404/Street_Fighter/assets/117922914/cf052359-a1d8-4793-b135-bd1d15f29f1a)

**Building a 2D Street Fighter game using Java and Swing involves creating a graphical user interface (GUI) and implementing various game components and mechanics. Let's explore each aspect in detail:**
# Setting up the GUI:
 - Begin by creating a main window for the game using the `JFrame` class provided by Swing.<br>
 - Customize the window's properties, such as size, title, and layout.<br>
 - Create a `JPanel` that will serve as the game canvas, displaying the characters and background.<br>
# Designing the Splash Screen: 
- Create a visually appealing image or animation that represents the Street Fighter game.<br>
- Design the splash screen to reflect the game's theme, incorporating the game's logo, characters, or other relevant elements.<br>
 - Use image editing tools or animation software to create the desired visual effect for the splash screen.<br>
 <img width="1440" alt="Screenshot 2023-06-28 at 5 55 57 PM" src="https://github.com/king4404/king4404/assets/117922914/4c96e5cc-5661-48f1-9456-2e5abfaaad9d">

# Implementing the Splash Screen:
 - Create a separate class specifically for the splash screen functionality.<br>
- In this class, extend the JFrame class to create a new window for the splash screen.<br>
 - Set the size, position, and appearance of the splash screen window.<br>
 - Add the designed splash screen image or animation to the window.<br>
 - Set a specific duration for the splash screen to be displayed before transitioning to the main game window.<br>
# Character and background design:
 - Design or obtain sprite sheets for the characters, which consist of individual images for various movements like walking, jumping, and attacking.<br>
 - Similarly, obtain or create background images that represent different fighting arenas.<br>
 - Split the sprite sheets into separate image files to be used for animation later.<br>
 <img width="1440" alt="Screenshot 2023-06-28 at 5 56 09 PM" src="https://github.com/king4404/king4404/assets/117922914/4783c214-cf3f-4c45-9aab-e056ff28f643">

# Player input:
 - Implement keyboard input listeners to capture player actions.<br>
 - Map specific keys to movements (e.g., arrow keys for walking and jumping) and attacks (e.g., punch, kick).<br>
 - Handle the events triggered by player inputs and update the character's position and state accordingly.<br>
# Game logic:
 - Implement the core game logic, including collision detection, health management, and attack mechanics.<br>
 - Detect collisions between characters and objects, such as punches connecting with opponents or characters hitting the edges of the screen.<br>
 - Manage health values for each character, reducing health when attacks land successfully.<br>
 - Implement a scoring system and determine the winner based on the remaining health or other victory conditions.<br>
 <img width="1440" alt="Screenshot 2023-06-28 at 5 56 43 PM" src="https://github.com/king4404/king4404/assets/117922914/5265c27e-7f52-406c-a437-13b816d4f704">

# Animation:
 - Create animation cycles using sprite sheets.<br>
 - Define the sequences of sprite images to display various character movements and attacks.<br>
 - Use timers or animation loops to switch between frames of the animation, creating the illusion of movement and action.<br>
# Sound effects and music:
 - Add sound effects to enhance the gameplay experience.<br>
 - Incorporate audio files for character grunts, punches, kicks, and other actions.<br>
 - Include background music that fits the mood of the game.<br>
 - Utilize the `javax.sound.sampled` package to play audio files during specific events or continuously throughout the game.<br>
# Game modes:
 - Implement different game modes to provide variety and replay value.<br>
 - Develop a two-player mode for local multiplayer, allowing two human players to compete against each other.<br>
# Testing and refining:
 - Thoroughly test the game to identify and fix bugs or glitches.<br>
 - Seek feedback from users to understand areas of improvement and make necessary adjustments to gameplay, controls, or graphics.<br>
 - Optimize the performance of the game, ensuring smooth animation and responsiveness.<br>
# Game Over and Victory Conditions:
 - When a character's health bar reaches zero, the opponent wins the round.<br>
 - The player who wins the required number of rounds first wins the match.<br>
 - A victory screen displays the winner and game statistics at the end of a match.<br>
 <img width="1440" alt="Screenshot 2023-06-28 at 6 21 05 PM" src="https://github.com/king4404/king4404/assets/117922914/fa672bf9-8354-4ca0-87b7-b1f2ed13ba8a">

# Deployment:
 - Package the game as a standalone executable or a runnable JAR file, making it easy for users to play the game on their systems.<br>
 - Distribute the game through appropriate channels, such as hosting it on a website, sharing it as a download, or submitting it to gaming platforms.<br>
# Building a Street Fighter game using Java and Swing 
allows you to create a visually engaging and interactive gaming experience, incorporating iconic characters, exciting fighting mechanics, and multiplayer capabilities. By following the steps outlined above and continuously refining your implementation, you can develop a compelling game that captures the essence of the Street Fighter series.
