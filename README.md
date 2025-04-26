
<div align="center">
  <h1>ActualCourseBot</h1>
  
  <p>
    A lightweight Java Telegram bot for getting real-time currency exchange rates.
  </p>
  
  <p>
    <img src="https://img.shields.io/badge/Java-17-blue.svg" alt="Java 17 Badge"/>
    <img src="https://img.shields.io/badge/Spring%20Boot-3.x-green.svg" alt="Spring Boot Badge"/>
    <img src="https://img.shields.io/badge/Maven-Build-red.svg" alt="Maven Badge"/>
    <img src="https://img.shields.io/badge/Telegram%20Bot-API-lightgrey.svg" alt="Telegram Bot API Badge"/>
  </p>
</div>

---

## 📌 Project Description

**ActualCourseBot** is a Java-based Telegram bot that allows users to easily check the latest currency exchange rates.  
It is designed to be simple, reliable, and easy to extend with additional features.

---

## 🚀 Technologies Used
- **Java 17**
- **Spring Boot 3**
- **Maven**
- **Lombok**
- **Telegram Bot API**
- **Docker** (optional, for deployment)
- **MongoDB** (optional, for future persistent storage)

---

## ⚙️ Installation and Setup

### Prerequisites
- Java 17+
- Maven
- Telegram Bot Token (you can obtain it from [@BotFather](https://t.me/BotFather))

### Steps to run locally

```bash
# 1. Clone the repository
git clone https://github.com/VladimirNilov28/ActualCourseBot.git

# 2. Navigate into the project directory
cd ActualCourseBot

# 3. Install dependencies and build the project
mvn clean install

# 4. Configure your Telegram Bot Token (e.g., in application.properties)

# 5. Start the application
mvn spring-boot:run
```

---

## 🎯 Features
- Fetches real-time currency exchange rates
- Handles simple and intuitive commands
- Clean and user-friendly responses
- Designed to be easily extendable with new features

---

## 🌟 Future Improvements
- Support for cryptocurrency prices
- Personalized user settings (favorite currencies, notifications)
- Multi-language support
- Docker containerization
- Persistent storage via MongoDB

---

## 📷 Screenshots

| Command | Example Response |
| :-----: | :------: |
| `/start` | "👋 Welcome! Send a currency code (e.g., USD, EUR) to get the latest exchange rate." |
| `/usd` | "💵 1 USD = 0.92 EUR (example data)" |
| `/eur` | "💶 1 EUR = 1.08 USD (example data)" |

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!  
Feel free to check the [issues page](https://github.com/VladimirNilov28/ActualCourseBot/issues) if you want to contribute.

