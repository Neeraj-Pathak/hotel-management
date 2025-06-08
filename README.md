Sure Neeraj! Here's a complete `README.md` you can directly copy and paste into your project. It includes everything: overview, features, tech stack, project structure, how to run, deployment on Render, Railway, and Netlify, along with Postman testing.

---

```markdown
# 🏨 Hotel Management System

A full-stack **Hotel Management System** for managing hotel operations like room management, customer bookings, and user authentication. Built with **Spring Boot** and **Spring Security** in the backend, and **ReactJS** in the frontend.

---

## 📌 Features

### 🔐 Authentication
- JWT-based login and registration
- Role-based access (Admin and Customer)
- Session persistence using localStorage

### 🛠️ Admin Functionalities
- Add, edit, delete, and view rooms
- View all reservations with pagination
- Secure APIs with role restrictions

### 👤 Customer Functionalities
- View available rooms
- Book a room
- View their bookings
- Cancel bookings

### 🎨 Frontend
- Responsive UI using plain CSS + Bootstrap
- Sidebar navigation for login/register
- Conditional rendering based on user role

---

## 🧰 Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA
- MySQL
- Maven

### Frontend
- React.js
- React Router DOM
- React Toastify
- Bootstrap & custom CSS

### Tools & Deployment
- IntelliJ IDEA
- Postman (API Testing)
- GitHub (Version control)
- Netlify (Frontend deployment)
- Render & Railway (Backend deployment)
- Docker (Containerization)

---

## 🌐 Project Structure

```

hotel-management/
├── backend/                  # Spring Boot app
│   ├── src/
│   ├── pom.xml
│   └── application.properties
├── frontend/                 # React app
│   ├── src/
│   ├── public/
│   └── package.json

````

---

## 🚀 How to Run Locally

### 1️⃣ Clone the repository

```bash
git clone https://github.com/your-username/hotel-management.git
cd hotel-management
````

---

### 2️⃣ Run the Backend (Spring Boot)

```bash
cd backend
./mvnw spring-boot:run
```

📍 **Backend runs at:** `http://localhost:8080`

Ensure your `application.properties` has correct MySQL config:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hotel_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

---

### 3️⃣ Run the Frontend (React)

```bash
cd frontend
npm install
npm start
```

📍 **Frontend runs at:** `http://localhost:3000`

Ensure `.env` is configured:

```
REACT_APP_BACKEND_URL=http://localhost:8080
```

---

## 📦 Deployment

### 🌍 Backend Deployment

| Platform    | Link                                                          | Notes                      |
| ----------- | ------------------------------------------------------------- | -------------------------- |
| 🚀 Render   | [Render Link](https://hotel-management-app-4bl2.onrender.com) | Hosted Spring Boot backend |
| 🛤️ Railway | (optional) Use if Render is down or backup                    |                            |

Set the following environment variables:

```env
frontend.url=https://hotelmanagementservice.netlify.app,http://localhost:3000
```

### 💻 Frontend Deployment

| Platform   | Link                                                                                     |
| ---------- | ---------------------------------------------------------------------------------------- |
| 🌐 Netlify | [https://hotelmanagementservice.netlify.app](https://hotelmanagementservice.netlify.app) |

To deploy:

```bash
cd frontend
npm run build
```

Upload the `build/` folder to Netlify or connect GitHub directly.

---

## 🧪 Postman API Testing

### 🔐 Login API

```
POST /api/auth/login
```

**Body:**

```json
{
  "email": "admin@example.com",
  "password": "yourpassword"
}
```

### 📝 Register API

```
POST /api/auth/register
```

**Body:**

```json
{
  "username": "neeraj",
  "email": "neeraj@example.com",
  "password": "123456"
}
```

### 📅 Book Room (Customer)

```
POST /customer/book
Authorization: Bearer <JWT_TOKEN>
```

**Body:**

```json
{
  "roomId": 2,
  "checkIn": "2024-06-20",
  "checkOut": "2024-06-22"
}
```

### 🧾 View Rooms (All Users)

```
GET /rooms?page=0
```

---

## ⚙️ CORS Setup

Your backend handles multiple allowed origins using:

```java
@Value("${frontend.url}")
private String frontendUrls;  // Comma-separated

res.setHeader("Access-Control-Allow-Origin", origin);  // validated from whitelist
```

Set the property in `application.properties` or Render/Netlify environment:

```
frontend.url=http://localhost:3000,https://hotelmanagementservice.netlify.app
```

---

## 📸 Screenshots

> *(Add images here)*

* Admin Room Dashboard
* Customer Bookings Page
* Login/Register Page
* Booking Form

---

## 📚 Key Learnings

* Implemented JWT Authentication in Spring Security
* Built paginated, secure APIs in Spring Boot
* Designed conditional UI with ReactJS
* Deployed full-stack app using Netlify + Render
* Used Postman to validate and debug API requests

---

## 🙋‍♂️ Author

**Neeraj Pathak**
B.Tech – CSE (AI & ML)
🌐 [LinkedIn](https://www.linkedin.com/in/yourprofile)
📧 [Gmail](neeraj.r.pathak07@gmail.com)

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

```

---

✅ **What to Do Next:**
1. Replace the links like GitHub, LinkedIn, Netlify with your actual URLs.
2. Optionally add `screenshots/` folder for UI previews.
3. Push this `README.md` file to your project root.

Let me know if you want this as a downloadable file or with your actual links inserted.
```
