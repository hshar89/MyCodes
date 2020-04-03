public class Chopstick{

int id;
Lock lock;

public Chopstick(int id){
 this.id = id;
 lock = new ReentrantLock();
}

}