Here is your cleaned-up and professionally styled `README.md`, with consistent formatting, spacing, and clear font usage (Markdown-compliant). It's ready to copy and paste directly:

---

```markdown
# 🏨 Hotel Management System

A full-stack **Hotel Management System** for managing hotel operations like room management, customer bookings, and user authentication. Built using **Spring Boot + Spring Security** in the backend and **ReactJS** in the frontend.

---

## 📌 Features

### 🔐 Authentication
- JWT-based login & registration
- Role-based access (Admin / Customer)
- Session persistence with `localStorage`

### 🛠️ Admin Panel
- Add, update, delete, view all rooms
- View all customer reservations (paginated)
- Respond to customer reservations (Approve,Reject)
- Manage secure backend APIs

### 👤 Customer Panel
- View and book available rooms
- View their own bookings

### 🎨 UI/UX
- Responsive and clean design using CSS + Bootstrap
- Conditional sidebar UI for different roles
- Toast notifications for actions and errors

---

## 🧰 Tech Stack

### 🔙 Backend
- Java 17
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA
- MySQL
- Maven

### 🔜 Frontend
- React.js
- React Router DOM
- React Toastify
- Bootstrap 5
- Custom CSS

### 🛠 Tools & Deployment
- IntelliJ IDEA (Backend)
- VS Code (Frontend)
- Postman (API Testing)
- GitHub (Version Control)
- Netlify (Frontend Deployment)
- Render & Railway (Backend Deployment)
- Docker (Optional)

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

## 🚀 Getting Started (Local Setup)

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/your-username/hotel-management.git
cd hotel-management
````

---

### 2️⃣ Backend Setup

```bash
cd backend
./mvnw spring-boot:run
```

📍 Runs at: `http://localhost:8080`

Update `application.properties` with your DB config:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hotel_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

---

### 3️⃣ Frontend Setup

```bash
cd frontend
npm install
npm start
```

📍 Runs at: `http://localhost:3000`

`.env` setup (create this file):

```
REACT_APP_BACKEND_URL=http://localhost:8080
```

---

## 📦 Deployment

### 🌍 Backend (Render & Railway)

1. Deploy to **Render** or **Railway**
2. Set this environment variable:

```env
frontend.url=https://hotelmanagementservice.netlify.app,http://localhost:3000
```

3. CORS handled using whitelist in `SimpleCorsFilter`

---

### 💻 Frontend (Netlify)

| Platform   | URL                                                                                      |
| ---------- | ---------------------------------------------------------------------------------------- |
| 🌐 Netlify | [https://hotelmanagementservice.netlify.app](https://hotelmanagementservice.netlify.app) |

```bash
cd frontend
npm run build
```

Upload `build/` to Netlify or link repo for auto-deploy.

---

## 🧪 Postman API Testing

### 🔐 Login

```http
POST /api/auth/login
```

```json
{
  "email": "admin@example.com",
  "password": "yourpassword"
}
```

---

### 📝 Register

```http
POST /api/auth/register
```

```json
{
  "username": "neeraj",
  "email": "neeraj@example.com",
  "password": "123456"
}
```

---

### 📅 Book Room

```http
POST /customer/book
Authorization: Bearer <JWT_TOKEN>
```

```json
{
  "roomId": 2,
  "checkIn": "2024-06-20",
  "checkOut": "2024-06-22"
}
```

---

### 🧾 View Rooms

```http
GET /rooms?page=0
```

---

## ⚙️ CORS Configuration

In `SimpleCorsFilter.java`:

```java
@Value("${frontend.url}")
private String frontendUrls;

res.setHeader("Access-Control-Allow-Origin", origin); // validated
```

Set in Render/Railway environment or `.properties`:

```properties
frontend.url=http://localhost:3000,https://hotelmanagementservice.netlify.app
```

---

## 📸 Screenshots

### 🏠 Home Page

![Home](https://github.com/user-attachments/assets/24994599-914d-4e70-83fd-f27754409cd1)

### 🧾 Registration Form

![Register](https://github.com/user-attachments/assets/89574f57-48ea-4e71-be33-e07cecaf74f0)

### 🔐 Login

![Login](https://github.com/user-attachments/assets/8d7b7961-eff4-4456-9fa0-cf4c9d5bbda8)

### 🛠️ Admin Post Room

![Post Room](https://github.com/user-attachments/assets/12215b20-0518-47f0-b1cc-dd8eb0ed4ed3)

### 📋 Admin Room List

![Rooms](https://github.com/user-attachments/assets/c942d6da-7b1f-40c0-9dce-bf1524f3d586)

### 🧾 Admin Reservations

![Reservations](https://github.com/user-attachments/assets/d86d4922-1389-433c-82cb-786a8c5e281a)

### 👤 Customer View & Book Rooms

![Customer Rooms](https://github.com/user-attachments/assets/d3cf02fe-ec4e-4853-bc19-831926af7424)

### 📅 Customer Bookings

![Bookings](https://github.com/user-attachments/assets/e5cb3fb1-b552-4522-bb07-ebd2ccc16834)

---

## 📚 Key Learnings

* ✅ Implemented JWT Authentication using Spring Security
* ✅ Built paginated and secured REST APIs with Spring Boot
* ✅ Designed conditional dynamic UI using React
* ✅ Deployed a full-stack project using Netlify and Render
* ✅ Validated API requests with Postman and debugged CORS issues

---

## 🙋‍♂️ Author

**Neeraj Pathak**
🎓 B.Tech – CSE (AI & ML)
🔗 [LinkedIn](https://www.linkedin.com/in/yourprofile)
📧 [neeraj.r.pathak07@gmail.com](mailto:neeraj.r.pathak07@gmail.com)

---

## 📄 License

This project is licensed under the **MIT License**.
See the [LICENSE](LICENSE) file for more details.

