# RESTful API Design

## Project

**Task Management System**

---

# API Endpoints

---

## 1. Lấy danh sách User

### Request

```
GET /users
```

### Response

```json
[
    {
        "id":1,
        "name":"John",
        "email":"john@gmail.com",
        "role":"USER"
    }
]
```

---

## 2. Tạo User

### Request

```
POST /users
```

### Body

```json
{
    "name":"John",
    "email":"john@gmail.com",
    "role":"USER"
}
```

### Validation

- name không được để trống
- email đúng định dạng
- role phải là USER hoặc ADMIN

### Response

```
201 Created
```

---

## 3. Cập nhật Role User

### Request

```
PATCH /users/{id}
```

### Body

```json
{
    "role":"ADMIN"
}
```

### Response

```
200 OK
```

---

## 4. Xóa User

### Request

```
DELETE /users/{id}
```

### Response

```
204 No Content
```

---

## 5. Lấy danh sách Task

### Request

```
GET /tasks
```

### Response

```json
[
    {
        "id":1,
        "title":"Design API",
        "priority":"HIGH",
        "status":"TODO",
        "userId":1
    }
]
```

---

## 6. Tạo Task

### Request

```
POST /tasks
```

### Body

```json
{
    "title":"Design API",
    "description":"RESTful API",
    "priority":"HIGH",
    "status":"TODO",
    "userId":1
}
```

### Validation

- title không được để trống
- priority phải là LOW, MEDIUM hoặc HIGH
- status hợp lệ
- userId phải tồn tại trong hệ thống

### Response

```
201 Created
```

---

## 7. Cập nhật trạng thái Task

### Request

```
PATCH /tasks/{id}
```

### Body

```json
{
    "status":"DONE"
}
```

### Response

```
200 OK
```

---

## 8. Xóa Task

### Request

```
DELETE /tasks/{id}
```

### Response

```
204 No Content
```

---

## 9. Tìm Task có Priority = HIGH

### Request

```
GET /tasks?priority=HIGH
```

### Response

```json
[
    {
        "id":1,
        "title":"Design API",
        "priority":"HIGH"
    }
]
```

---

## 10. Tìm Task có Priority = HIGH và User ID = 1

### Request

```
GET /tasks?priority=HIGH&userId=1
```

### Response

```json
[
    {
        "id":1,
        "title":"Design API",
        "priority":"HIGH",
        "userId":1
    }
]
```

---

## 11. Liệt kê toàn bộ Task của User

### Request

```
GET /users/{id}/tasks
```

### Response

```json
[
    {
        "id":1,
        "title":"Design API"
    },
    {
        "id":2,
        "title":"Write Documentation"
    }
]
```

---

## 12. Gắn Task cho User

### Request

```
PATCH /tasks/{taskId}
```

### Body

```json
{
    "userId":2
}
```

### Validation

- User phải tồn tại.
- Task phải tồn tại.

### Response

```
200 OK
```

---