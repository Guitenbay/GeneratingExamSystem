# GeneratingExamSystem
    大三下软件质量组卷系统

---

## 接口文档

### 获取用户信息 (创建 session)
    Url: "/user"
    Method: GET
    Param: id

**return**
```json
{
    ...
}
```

### 获取全部大纲
    Url: "/syllabuses"
    Method: GET

**return**
```json
[
    {
        ...
    },
    {
        ...
    }
]
``` 

### 根据大纲获取全部章节
    Url: "/chapters"
    Method: GET
    Param: syllabusId

**return**
```json
[
    {
        ...
    },
    {
        ...
    }
]
```

### 根据 id 获取章节
    Url: "/chapter"
    Method: GET
    Param: id

**return**
```json
{
    ...
}
```

### 根据章节获取全部知识点
    Url: "/kps"
    Method: GET
    Param: chapterId

**return**
```json
[
    {
        ...
    },
    {
        ...
    }
]
```

### 根据知识点获取全部问题
    Url: "/questions"
    Method: GET
    Param: kpId

**return**
```json
[
    {
        ...
    },
    {
        ...
    }
]
```

### 根据 id 获取问题
    Url: "/question"
    Method: GET
    Param: id

**return**
```json
{
    ...
}
```

### 根据类型获取全部问题
    Url: "/questions"
    Method: GET
    Param: type

**return**
```json
[
    {
        ...
    },
    {
        ...
    }
]
```

### 根据用户 id 获取全部试卷
    Url: "/exam/all"
    Method: GET

**return**
```json
[
    {
        ...
    },
    {
        ...
    }
]
```

### 根据 id 获取试卷
    Url: "/exam"
    Method: GET
    Param: id

**return**
```json
{
    ...
}
```

### 更新试卷
    Url: "/exam/update"
    Method: POST

**input**
```json
{
    "id":1,
    "name":"test",
    "questions":[
        {
            "number":2,
            "questionId":84
        }
    ],
    "userId":1
}
```

**return**
```json
{
    result: true,
    message: ""
}
```

### 创建试卷
    Url: "/exam/new"
    Method: GET
    Param: name

**return**
```json
{
    result: true,
    message: ""
}
```
