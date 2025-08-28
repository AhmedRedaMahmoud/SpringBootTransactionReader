# 🚀 دليل استخدام Spring Boot Transaction Reader API

هذا الدليل يوضح كيفية استخدام endpoints الخاصة بقراءة المعاملات من جدول HR.MD_TRANSACTION_CURRENT.

## 📋 **جدول المحتويات**

- [متطلبات التشغيل](#متطلبات-التشغيل)
- [تشغيل التطبيق](#تشغيل-التطبيق)
- [endpoints المعاملات](#endpoints-المعاملات)
- [استكشاف الأخطاء](#استكشاف-الأخطاء)

---

## 🔧 **متطلبات التشغيل**

### **المتطلبات الأساسية:**

- Java 17+
- Maven 3.8+
- Oracle Database 12c+
- VS Code أو IDE أخرى

### **قاعدة البيانات:**

```sql
-- الاتصال بقاعدة البيانات Oracle
User: HR
Password: hr
URL: jdbc:oracle:thin:@localhost:1521:orcl
```

---

## ▶️ **تشغيل التطبيق**

### **1. تشغيل التطبيق:**

```bash
cd SpringBootTransactionReader
mvn spring-boot:run
```

### **2. التحقق من حالة التطبيق:**

```powershell
Invoke-WebRequest -Uri "http://localhost:8081/api/health" -Method GET
```

**النتيجة المتوقعة:**

```json
{
  "database": "Connected",
  "application": "Spring Boot Transaction Reader API",
  "version": "1.0.0",
  "status": "UP",
  "timestamp": 1755867513092
}
```

---

## 💳 **endpoints المعاملات**

### **Base URL:** `http://localhost:8081/api/transactions`

### **1. جلب جميع المعاملات**

**GET** `/`

```powershell
$transactions = Invoke-WebRequest -Uri "http://localhost:8081/api/transactions" -Method GET
$transactions.Content | ConvertFrom-Json | ConvertTo-Json -Depth 2
```

### **2. جلب معاملة بواسطة ID**

**GET** `/{id}`

```powershell
$transactionId = 1
$transaction = Invoke-WebRequest -Uri "http://localhost:8081/api/transactions/$transactionId" -Method GET
```

### **3. البحث بواسطة رقم المعاملة**

**GET** `/trans-id/{transId}`

```powershell
$transId = "TXN001"
$transaction = Invoke-WebRequest -Uri "http://localhost:8081/api/transactions/trans-id/$transId" -Method GET
```

---

## ❌ **استكشاف الأخطاء**

### **الأخطاء الشائعة والحلول:**

#### **1. خطأ 404 Not Found**

```json
{
  "error": "المعاملة غير موجودة",
  "message": "لا يمكن العثور على المعاملة بالمعرف المطلوب"
}
```

**الحل:**
- تأكد من صحة المعرف المستخدم
- تحقق من وجود المعاملة في قاعدة البيانات

#### **2. خطأ 500 Internal Server Error**

```json
{
  "error": "خطأ في النظام"
}
```

**الحل:**
- تحقق من اتصال قاعدة البيانات
- راجع logs التطبيق للتفاصيل

#### **3. خطأ في قاعدة البيانات**

**الحل:**

```sql
-- التحقق من الاتصال
SELECT 1 FROM DUAL;

-- التحقق من الجدول
SELECT TABLE_NAME FROM USER_TABLES WHERE TABLE_NAME = 'MD_TRANSACTION_CURRENT';
```

### **ملاحظات هامة**

- يتم استخدام HikariCP لإدارة اتصالات قاعدة البيانات
- يتم تفعيل logging للاستعلامات SQL في بيئة التطوير
- يتم استخدام معالجة الأخطاء العامة للتعامل مع جميع أنواع الأخطاء

---

**🎉 تم إعداد النظام بنجاح! يمكنك الآن استخدام عمليات القراءة المتاحة.**
