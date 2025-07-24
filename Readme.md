✈️ MakeMyTrip Automation with Selenium
This project automates flight search functionality on MakeMyTrip using Java and Selenium WebDriver.

It simulates a user searching for flights by:

Closing the modal popup

Entering the From and To cities

Selecting a date 3 days from today

📸 Demo Screenshot (Optional)
(You can add a screenshot or screen recording of the automation running here for better visualization)

![Home Page Screenshot](screenshots/MakemytripHomePage.png)

<img src="screenshots/MakemytripHomePage.png" alt="Home Page" width="600"/>


📦 Tech Stack
🧑‍💻 Java

🌐 Selenium WebDriver

🧭 ChromeDriver

🛠️ Maven or Manual JAR setup (for dependencies)

🧰 Prerequisites
Before running the project, ensure you have:

✅ Java JDK 11

✅ Chrome browser installed

✅ ChromeDriver (matching Chrome version) available in system path

✅ Selenium Java libraries (add manually or via Maven)



🧠 What the Script Does
Step	Action
🏁	Launches Chrome and opens MakeMyTrip

❌	Closes the initial modal popup

🌆	Enters From city (Chennai)

🧭	Selects the top suggestion from the dropdown

🌇	Enters To city (Mumbai)

📌	Selects the top suggestion again

📅	Chooses a travel date 3 days from today

📴	Closes and quits the browser

✏️ Code Snippets

📍 Enter From City
enterTextInFromTextBox(wait, "Chennai");

📍 Enter To City
forCityInputTextBox.sendKeys("Mumbai");

📍 Select Date (+3 Days)
LocalDate targetDate = LocalDate.now().plusDays(3);

⚙️ Customization
What	How

🌆 Change cities	Modify values in enterTextInFromTextBox() and forCityInputTextBox.sendKeys()

📅 Change travel date	Change the plusDays(3) logic

🕵️ Improve reliability	Update locators or add more wait conditions if MakeMyTrip updates its UI

