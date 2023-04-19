import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public class WriteToFile extends Thread{
    public Trainset[] trainsArray;
    public String file = "AppState.txt";

    public WriteToFile(Trainset[] arr){
        this.trainsArray = arr;
    }
    public void run(){
        while(!Thread.interrupted()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (int i = 0; i < trainsArray.length; i++) {
                    while (trainsArray[i].locomotive.route == null){
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                sortTrainsets();
                writer.write("List of trainsets:\n");
                for(int i = 0; i < trainsArray.length; i++)
                    writer.write(trainsArray[i].toString());
            }
            catch(Exception e){
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void sortTrainsets(){
        for(int i = 0; i < trainsArray.length - 1; i++){
            int maxIndex = i;
            for(int j = i + 1; j < trainsArray.length; j++){
                if(trainsArray[j].locomotive.calcDistance() > trainsArray[maxIndex].locomotive.calcDistance()){
                    maxIndex = j;
                }
            }
            Trainset tmp = trainsArray[maxIndex];
            trainsArray[maxIndex] = trainsArray[i];
            trainsArray[i] = tmp;
        }
    }
}
