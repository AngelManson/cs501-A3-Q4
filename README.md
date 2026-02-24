# Responsive Layout Challenge: Phone vs Tablet


# 1. What the App Does

This Android application demonstrates a responsive screen built using Jetpack Compose and Material 3 components. The app adapts its layout based on screen width: on narrow screens (phones), it uses a single Column layout to display navigation options and content stacked vertically. On wide screens (tablets or landscape mode), it switches to a Row layout with two panes— a left navigation pane using a NavigationRail and a right detail pane combining Box and Column components. Users can select different navigation items to update the content displayed in the detail pane.


# 2. Screenshot of the Running App

<img width="750" height="400" alt="Screenshot_20260224_153438" src="https://github.com/user-attachments/assets/dc9f89b7-cf24-4bfd-b88f-542307a89f71" />

<img width="400" height="750" alt="Screenshot_20260224_153300" src="https://github.com/user-attachments/assets/30c724f1-e70e-4f30-95fb-b2b50b3a2fa5" />

<img width="400" height="750" alt="Screenshot_20260224_153305" src="https://github.com/user-attachments/assets/f662ef0f-5ba9-477e-b8fd-0a4a3848e259" />




# 3. Device / Emulator / SDK Version

- **Emulator Device:** Medium Phone API 36.1 (Android 16.0 ("Baklava")) / Medium Tablet API 35 (Android 15.0 ("VanillaCream"))   
- **Minimum SDK:** 26  
- **Target SDK:** 36


# 4. AI Disclosure

While working on the Responsive Layout assignment, I used ChatGPT to help me understand how to structure a layout that adapts to both phone and tablet screens. I ran into issues where my app would look somewhat correct in the preview but behave differently on a device, especially with switching between a single-column layout on narrow screens and a two-pane Row layout on wider screens. At first Chat suggested several 'solutions' that simply ended up not working and would change the whole app so I ended up using the lecture examples as the format which fixed my issue. Chat also helped me fix some isses I had with my imports, I ended up having to manually add a dependency. 

