public class TestString {

	public static void main(String[] args) {
		testBuffer();
		//testBuilder();
	}

	public static void testBuffer() {
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i < 10; i++) {
			 new Thread(new Runnable() {
		            @Override
		            public void run() {
		            	for(int j = 0; j < 1000; j++) {		            		
		            		buffer.append("a");
		            	}
		            }
		        }).start();
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("线程安全:" + buffer.length());
	}
	
	public static void testBuilder() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < 10; i++) {
			 new Thread(new Runnable() {
		            @Override
		            public void run() {
		            	for(int j = 0; j < 1000; j++) {		            		
		            		builder.append("a");
		            	}
		            }
		        }).start();
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("线程不安全:"+builder.length());
	}
}
