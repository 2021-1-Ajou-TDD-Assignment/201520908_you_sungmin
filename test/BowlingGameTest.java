import static org.junit.Assert.*;
import org.junit.*;

public class BowlingGameTest {

	protected Game g;
	
	@Before
	public void setUp() {
		
		g = new Game();
		
	}
	
	@Test
	public void testGutterGame() {
		
		rollMany(20,0);
		
		assertEquals(0, g.score());
	}
		
	@Test
	public void testAllOneGame() {
		
		rollMany(20, 1);
		
		assertEquals(20, g.score());
	}

	protected void rollMany(int n, int pins) {
		for(int i = 0; i < n; ++i) {
			
			g.roll(pins);
		}
	}
}
