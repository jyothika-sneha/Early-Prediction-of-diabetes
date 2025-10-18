
# 🩺 Early Prediction of Diabetes
*A Machine Learning–based Android application for predicting the likelihood of diabetes using health and lifestyle data.*

![GitHub repo size](https://img.shields.io/github/repo-size/jyothika-sneha/Early-Prediction-of-diabetes?color=brightgreen)
![GitHub last commit](https://img.shields.io/github/last-commit/jyothika-sneha/Early-Prediction-of-diabetes?color=blue)
![GitHub license](https://img.shields.io/github/license/jyothika-sneha/Early-Prediction-of-diabetes?color=yellow)

---

## 📘 Overview

**Early Prediction of Diabetes** is a **machine learning and Android application** designed to estimate the risk of diabetes in individuals based on their health and lifestyle factors.  
It uses a **Random Forest model** trained on health survey data (such as the **Behavioral Risk Factor Surveillance System — BRFSS**) and provides predictions through an **easy-to-use Android interface**.

This project demonstrates how real-world healthcare data can be leveraged to assist with early diabetes risk identification in a mobile environment.

---

## 🎯 Objectives

- To apply machine learning techniques for predicting diabetes risk.  
- To use publicly available health data for model training and validation.  
- To make diabetes risk assessment more **accessible** and **user-friendly** through an Android app.  
- To create an educational, proof-of-concept tool for early screening support.

---

## 🧠 Key Features

✅ **ML-Based Prediction** – Uses a trained Random Forest classifier on historical health data.  
✅ **Android Integration** – Provides real-time, on-device predictions via a clean mobile UI.  
✅ **User-Centric Design** – Collects health information in an intuitive form layout.  
✅ **Offline Functionality** – Runs locally without the need for an active internet connection.  
✅ **Privacy-Friendly** – No user data is stored or transmitted externally.

---

## 🏗️ System Architecture

               ┌──────────────────────────────┐
               │  BRFSS Health Dataset         │
               │  (Historical Health Data)     │
               └─────────────┬────────────────┘
                             │
                             ▼
               ┌──────────────────────────────┐
               │  Data Preprocessing           │
               │  - Cleaning & Imputation      │
               │  - Feature Scaling/Encoding   │
               └─────────────┬────────────────┘
                             │
                             ▼
               ┌──────────────────────────────┐
               │  Model Training (Python)      │
               │  - Random Forest Classifier   │
               │  - Evaluation Metrics         │
               └─────────────┬────────────────┘
                             │
                             ▼
               ┌──────────────────────────────┐
               │  Android Application          │
               │  - User Input Form            │
               │  - Local Prediction Logic     │
               │  - Output Display             │
               └──────────────────────────────┘
## 📊 Dataset Details (BRFSS)

- **Source:** Centers for Disease Control and Prevention (CDC)  
- **Type:** Publicly available annual health survey  
- **Features Used:**  
  - Age  
  - Body Mass Index (BMI)  
  - Blood Pressure  
  - Glucose Level  
  - Physical Activity  
  - Smoking and Alcohol Habits  
  - General Health Status  
- **Target Variable:** `Diabetes` (0 = No Diabetes, 1 = Diabetes)

  ## 🧮 Model Development Workflow

1. **Data Loading & Cleaning** – Remove missing or inconsistent entries.  
2. **Feature Selection** – Identify most influential health attributes.  
3. **Model Training** – Train a Random Forest Classifier using scikit-learn.  
4. **Model Evaluation** – Use metrics like accuracy, precision, recall, and ROC-AUC to assess performance.  
5. **Model Integration** – Embed trained model in Android app for user-side predictions.



