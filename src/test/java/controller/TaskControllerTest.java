package controller;

import br.ce.wcaquino.taskbackend.controller.TaskController;
import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
public class TaskControllerTest {

    @Mock
    private TaskRepo taskRepo;

    @InjectMocks
    private TaskController taskController;

/*    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
*/
    @Test
    public void naoDeveSalvarTarefasSemDescricao()  {
        Task task = new Task();
        task.setDueDate(LocalDate.now());
        try{
            taskController.save(task);
            Assert.fail("Não deveria chegar neste ponto");
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the task description", e.getMessage());
        }

    }

    @Test
    public void naoDeveSalvarTarefasSemData() {
        Task task = new Task();
        task.setTask("Colocar o lixo para fora");
        try{
            taskController.save(task);
            Assert.fail("Não deveria chegar neste ponto");
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the due date", e.getMessage());
        }
    }

    @Test
    public void naoDeveSalvarTarefasComDataPassada()  {
        Task task = new Task();
        task.setTask("Colocar o lixo para fora");
        task.setDueDate(LocalDate.of(2014,1,1));
        try{
            taskController.save(task);
            Assert.fail("Não deveria chegar neste ponto");
        } catch (ValidationException e) {
            Assert.assertEquals("Due date must not be in past", e.getMessage());
        }
    }

    @Test
    public void deveSalvarTarefaComSucesso() throws ValidationException{
        Task task = new Task();
        task.setTask("Colocar o lixo para fora");
        task.setDueDate(LocalDate.now());
        taskController.save(task);
        Mockito.verify(taskRepo).save(task);

    }
}

