package com.testProjects.todolist;

import com.testProjects.todolist.models.Task;
import com.testProjects.todolist.services.TaskService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc // Включаем поддержку MockMvc
class TodoListApplicationTests {

    @Autowired
    private TaskService taskService; // Внедрение TaskService для теста testCreateTask

    @Autowired
    private MockMvc mockMvc; // Внедрение MockMvc для теста testGetTaskById

    private WebDriver driver; // WebDriver для теста testCreateTaskViaUI

    @BeforeEach
    void setUp() {
        // Настройка WebDriver перед каждым тестом
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Укажите путь к chromedriver
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        // Закрытие WebDriver после каждого теста
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void contextLoads() {
        // Этот тест проверяет, что контекст Spring загружается корректно
    }

    @Test
    void testCreateTask() {
        // Создаем новую задачу
        Task task = new Task();
        task.setTitle("Test Task");
        task.setDescription("Test Description");

        // Сохраняем задачу через сервис
        Task savedTask = taskService.saveTask(task);

        // Проверяем, что задача успешно сохранена и имеет ID
        assertNotNull(savedTask.getId(), "ID задачи не должен быть null");
        assertEquals("Test Task", savedTask.getTitle(), "Заголовок задачи должен совпадать");
    }

    @Test
    void testGetTaskById() throws Exception {
        // Тестируем GET-запрос к /tasks/1
        mockMvc.perform(get("/tasks/1"))
               .andExpect(status().isOk()) // Ожидаем статус 200 OK
               .andExpect(jsonPath("$.title").value("Test Task")); // Ожидаем, что заголовок задачи равен "Test Task"
    }

    @Test
    void testCreateTaskViaUI() {
        // Открываем страницу создания задачи
        driver.get("http://localhost:8080/tasks/create");

        // Заполняем форму
        driver.findElement(By.id("title")).sendKeys("Test Task");
        driver.findElement(By.id("description")).sendKeys("Test Description");

        // Нажимаем кнопку "Создать"
        driver.findElement(By.id("submit")).click();

        // Проверяем, что задача была создана и отображается на странице
        assertTrue(driver.getPageSource().contains("Test Task"), "Задача должна быть создана и отображена на странице");
    }
}