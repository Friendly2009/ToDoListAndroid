# Todo List App

## Описание

Это простое приложение для создания и управления списком задач (Todo List), разработанное с использованием Jetpack Compose и SQLite. Приложение позволяет пользователям добавлять, редактировать и удалять задачи, а также сохранять их в локальной базе данных SQLite.

## Функциональные возможности

- Добавление новой задачи
- Редактирование существующей задачи
- Удаление задачи
- Просмотр списка задач
- Сохранение данных в локальной базе данных SQLite

## Технологии

- Kotlin
- Jetpack Compose
- SQLite
- Android Studio

## Установка

1. Склонируйте репозиторий:
```
bash
   git clone https://github.com/Friendly2009/ToDoListAndroid
```

2. Откройте проект в Android Studio.

3. Убедитесь, что у вас установлены все необходимые зависимости. В файле build.gradle вашего модуля должны быть следующие зависимости:
```
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation("androidx.compose.material3:material3:1.1.0")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}
```
4. Синхронизируйте проект.

5. Запустите приложение на эмуляторе или реальном устройстве.

## Использование

1. Запустите приложение.
2. На главном экране вы увидите список ваших задач.
3. Чтобы добавить новую задачу, нажмите на кнопку "Добавить задачу".
4. Введите текст задачи и нажмите "Сохранить".
5. Чтобы редактировать задачу, нажмите на неё в списке, внесите изменения и сохраните.
6. Чтобы удалить задачу, проведите по ней влево или вправо.

## Структура проекта

- MainActivity.kt - главный экран приложения.
- TodoItem.kt - модель данных для задачи.
- TodoDatabase.kt - класс для работы с базой данных SQLite.
- TodoDao.kt - интерфейс для доступа к данным.
- TodoViewModel.kt - ViewModel для управления состоянием UI.





   
