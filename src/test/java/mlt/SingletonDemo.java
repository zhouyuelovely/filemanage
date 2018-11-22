package mlt;

/**
 * @author MLT
 *
 */
public class SingletonDemo {
	
		/* //static 确保在类加载的时候就会初始化该对象
	    private final static SingletonDemo singleton = new SingletonDemo();
	    // 必须是私有构造方法，防止其他地方通过构造方法来实例化对象
	    private SingletonDemo(){
	    }
	    // 是一个公共的静态方法，用于对外提供唯一的对象
	    public SingletonDemo getInstance(){
	        return singleton;
	    }*/
	
//-----------------------------------------单例_饿汉模式----------------------------------------
	
	   /* // 不允许其他地方通过构造方法进行实例化对象
	    private SingletonDemo(){}
	    //对外提供可获取唯一实例化对象的公共方法
	    public static SingletonDemo getInstance(){
	        return Singleton.SINGLETON.getInstance();
	    }
	    private enum Singleton{
	        SINGLETON;
	        private SingletonDemo singleton;
	        Singleton(){
	            singleton = new SingletonDemo();
	        }
	        public SingletonDemo getInstance(){
	            return singleton;
	        }
	    }*/
	
//-----------------------------------------单例_枚举---------------------------------------------
	
	   /* //static 确保在类加载的时候就会初始化该对象
	    private static SingletonDemo singleton = null;
	    // 必须是私有构造方法，防止其他地方通过构造方法来实例化对象
	    private SingletonDemo(){
	    }
	    // 是一个公共的静态方法，用于对外提供唯一的对象
	    public static SingletonDemo getInstance(){
	        if(singleton==null){
	            singleton = new SingletonDemo();
	        }
	        return singleton;
	    }*/
	
//------------单例_懒汉_线程不安全(在有多线程使用的情况下不要使用，否则可能会造成创建多个实例对象。一般建议不使用该种方式。)----------------
	
	/* //static 确保在类加载的时候就会初始化该对象
    private static SingletonDemo singleton = null;

    // 必须是私有构造方法，防止其他地方通过构造方法来实例化对象
    private SingletonDemo(){
    }
    // 是一个公共的静态方法，用于对外提供唯一的对象
    public static SingletonDemo getInstance(){
        if(singleton==null){
            singleton = new SingletonDemo();
        }
        return singleton;
    }*/
	
//------------------------------------------------懒汉式-线程安全-同步方法------------------------------------------
	
	  //static 确保在类加载的时候就会初始化该对象
    private static volatile SingletonDemo singleton = null;

    // 必须是私有构造方法，防止其他地方通过构造方法来实例化对象
    private SingletonDemo(){
    }
    // 是一个公共的静态方法，用于对外提供唯一的对象
    public static SingletonDemo getInstance(){
        if(singleton==null){
            synchronized (SingletonDemo.class){
                if(singleton==null) { //为了防止多个线程进行实例化
                    singleton = new SingletonDemo();
                }
            }
        }
        return singleton;
    }
    
//------------------------------------------懒汉式-线程安全-双重锁------------------------------------------------------
}