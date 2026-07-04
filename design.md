# 📘 RESTful API Design

## 1. Overview

### Base URL

```text
/api/v1
```

### Resources

* `/users`
* `/tasks`

---

# 2. Data Model

## User

| Field    | Type   | Description      |
| -------- | ------ | ---------------- |
| id       | Long   | User ID          |
| username | String | Username         |
| email    | String | Email            |
| role     | String | `ADMIN` | `USER` |

## Task

| Field       | Type   | Description               |
| ----------- | ------ | ------------------------- |
| id          | Long   | Task ID                   |
| title       | String | Task title                |
| description | String | Task description          |
| priority    | String | `HIGH` | `NORMAL` | `LOW` |
| assignedTo  | Long   | User ID                   |

---

# 3. RESTful API

## User APIs

| Method | Endpoint           | Description       |
| ------ | ------------------ | ----------------- |
| GET    | `/users`           | Get all users     |
| POST   | `/users`           | Create a new user |
| PATCH  | `/users/{id}/role` | Update user role  |
| DELETE | `/users/{id}`      | Delete a user     |

---

## Task APIs

| Method | Endpoint             | Description        |
| ------ | -------------------- | ------------------ |
| GET    | `/tasks`             | Get all tasks      |
| POST   | `/tasks`             | Create a new task  |
| PATCH  | `/tasks/{id}/status` | Update task status |
| DELETE | `/tasks/{id}`        | Delete a task      |

---

# 4. Search APIs

## Get tasks by priority

```http
GET /tasks?priority=HIGH
```

Example

```text
GET /api/v1/tasks?priority=HIGH
```

---

## Get tasks by priority and assigned user

```http
GET /tasks?priority=HIGH&assignedTo=1
```

Example

```text
GET /api/v1/tasks?priority=HIGH&assignedTo=1
```

---

## Get all tasks of a user

```http
GET /users/{id}/tasks
```

Example

```text
GET /api/v1/users/1/tasks
```

---

# 5. Assign Task to User

Assign a task to a user.

```http
PATCH /tasks/{id}/assign
```

### Request Body

```json
{
  "assignedTo": 1
}
```

Example

```text
PATCH /api/v1/tasks/5/assign
```

---

# 6. HTTP Status Codes

| Code            | Meaning            |
| --------------- | ------------------ |
| 200 OK          | Request successful |
| 201 Created     | Resource created   |
| 204 No Content  | Resource deleted   |
| 400 Bad Request | Invalid request    |
| 404 Not Found   | Resource not found |

---

# 7. RESTful Design Rules

* Use plural nouns for resources (`/users`, `/tasks`).
* Use HTTP Methods correctly (`GET`, `POST`, `PATCH`, `DELETE`).
* Use Path Variable for resource identifiers.
* Use Query Parameters for filtering.
* Use JSON as request/response format.
* Keep URLs resource-oriented; avoid verbs in endpoint names.

---

# 8. API Summary

| Feature                       | Method | Endpoint                                   |
| ----------------------------- | ------ | ------------------------------------------ |
| Get all users                 | GET    | `/users`                                   |
| Create user                   | POST   | `/users`                                   |
| Update user role              | PATCH  | `/users/{id}/role`                         |
| Delete user                   | DELETE | `/users/{id}`                              |
| Get all tasks                 | GET    | `/tasks`                                   |
| Create task                   | POST   | `/tasks`                                   |
| Update task status            | PATCH  | `/tasks/{id}/status`                       |
| Delete task                   | DELETE | `/tasks/{id}`                              |
| Find tasks by priority        | GET    | `/tasks?priority=HIGH`                     |
| Find tasks by priority & user | GET    | `/tasks?priority=HIGH&assignedTo={userId}` |
| Get tasks of a user           | GET    | `/users/{id}/tasks`                        |
| Assign task to user           | PATCH  | `/tasks/{id}/assign`                       |
