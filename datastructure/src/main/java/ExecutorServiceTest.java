import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceTest {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String... args) {
        new ExecutorServiceTest().getThreads();
    }

    protected void getThreads() {
        //factory method of Executors class
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //Directoy create an ExecutorService
        //same as sourcecode for newSingleThreadExecutor()
        ExecutorService executorService1  = new ThreadPoolExecutor(1,
                1, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        //ExecutorService can execute Runnable and Callable tasks
        Runnable runnableTask = () -> {
            try{
                TimeUnit.MILLISECONDS.sleep(300);
            } catch(InterruptedException e) {
                logger.error("interrupted exception caught! ", e);
            }
        };

        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        try {
            List<Future<String>> futureTasks = executorService.invokeAll(callableTasks);
            for (Future<String> future : futureTasks) {
                System.out.printf("future task :: %s%n", future.get());
            }
        } catch (InterruptedException e) {
            logger.error("interrupted exception caught! ", e);
        } catch (ExecutionException e) {
            logger.error("execution exception caught! ", e);
        }


        //Tasks can be assigned to the ExecutorService in different ways
        //void execute() -> can't check the task status, is it running or executed
        //submit() submits a Callable or a Runnable task to an ExecutorService
        //and returns a result of type Future
        //Future<String> future = executorService.submit(callableTask)
        // invokeAny() assigns a collection of tasks to an ExecutorService, causing each to be executed, and
        //returns the result of a successful execution of one task (if there was a successful execution)
        // String result = executorService.invokeAny(callableTasks)
        // invokeAll() assigns a collection of tasks to an ExecutorService, causing each to be executed, and
        //returns the result of all task executions in the form of a list of objects of type Future.
        // List<Future<String>> futures = executorService.invokeAll(callableTasks);
        //shutdown executorService will make stop accepting new tasks and shutdown after all running threads finish
        //their current work


        // invokeAny(?), invokeAll()


















        /*executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Asynchronous task");
            }
        });*/

        executorService.shutdown();
    }
}
