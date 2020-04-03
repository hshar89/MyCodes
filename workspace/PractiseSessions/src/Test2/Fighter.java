package Test2;

public abstract class Fighter {
	
	KickBehaviour kb;
	JumpBehaviour jb;
	
	public void punch() {
		System.out.println("Default punch");
	}
	public void kick() 
    {  
        kb.Kick(); 
    } 
    public void jump() 
    { 
 
        jb.Jump(); 
    } 
    public void roll() 
    { 
        System.out.println("Default Roll"); 
    } 
    public void setKickBehavior(KickBehaviour kickBehavior) 
    { 
        this.kb = kickBehavior; 
    } 
    public void setJumpBehavior(JumpBehaviour jumpBehavior) 
    { 
        this.jb = jumpBehavior; 
    } 
    
    public abstract void display();
	
}
