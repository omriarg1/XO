package Race;
//OFEK CASPI - 208895367 Omri argaman - 314772351
public class Racer implements Runnable {
private static int globalId=1;
private int id;
private int speed;
private Track track;
public void run() {
	this.go();
}
public Racer(int speed,Track track) throws Exception {
	id=globalId++;
	this.track=track;
	if(speed>=1 && speed<=10)
	this.speed=speed;
	else throw new Exception("Speed must be between 1 and 10");
}
public void go() {
	Thread.currentThread().setPriority(this.speed);
	for(int i =0;i<100;i++) 
		System.out.println("Runner " + this.id + " ran "+ i + " meters");
	track.addfinishedRacer();
	System.out.println("Runner " + this.id + " finshed"+ track.getfinishedRacer() +"st");
}
}
