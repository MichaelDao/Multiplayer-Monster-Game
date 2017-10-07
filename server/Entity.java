public abstract class Entity {
	/*
	 * Base abstract entity class
	 * 
	 * Monster and Player classes extend this class
	 * 
	 * A quick note on desired direction: The direction a player is actually going
	 * is `direction`, and that should be used for calculating where they will be
	 * moving etc. `desired_direction` is the direction the player has indicated
	 * they want to be moving, but as the game uses pacman style gameplay if a wall
	 * happens to be in the way and they cannot turn, then their `desired_direction`
	 * and actual `direction` will be different, and each tick their position and
	 * `desired_direction` needs to be checked to see if their `direction` can be
	 * updated so they can start moving in their `desired_direction`
	 */

	private int direction;
	private int desired_direction;

	private int pos_x, pos_y; // I renamed it from x,y.

	public Entity() 
	{
		/*
		 * 0 = UP 
		 * 1 = DOWN 
		 * 2 = LEFT 
		 * 3 = RIGHT
		 */
		direction = 0;
		desired_direction = 0;
		return;
	}

	public void move() 
	{
		String output;

		// DEBUG, find out the current player coordinate
		output = "\nPlayer coordinate before move: ";
		output += this.get_pos_x() + "," + this.get_pos_y();
		System.out.println(output);
		
		/*
		 * Get players direction, and apply the move
		 */
		switch (direction) 
		{		
		
		case 2: // (x - 1, y) Left
			if (check_move(this.get_pos_x() - 1, this.get_pos_y()))
				// Update the player position if valid
				this.set_pos_x(this.get_pos_x() - 1);
			
				// teleport to node 40
				if (this.get_pos_x() == 0)
					this.set_pos_x(9);
			break;
			
		case 3: // (x + 1, y) Right
			if (check_move(this.get_pos_x() + 1, this.get_pos_y()))
				// Update the player position if valid
				this.set_pos_x(this.get_pos_x() + 1);
			
			// teleport to node 4
			if (this.get_pos_x() ==10)
					this.set_pos_x(1);
			break;
			
		case 1: // (x, y - 1) Down
			if (check_move(this.get_pos_x(), this.get_pos_y() - 1))
				
				// Update the player position if valid
				this.set_pos_y(this.get_pos_y() - 1);

				// Teleport to node 26
				if (this.get_pos_y() == 0)
					this.set_pos_y(9);
			break;

		case 0: // (x, y + 1) Up
			if (check_move(this.get_pos_x(), this.get_pos_y() + 1))
			{	
				// Update the player position if valid
				this.set_pos_y(this.get_pos_y() + 1);
				
				// Teleport to node 18
				if (this.get_pos_y() == 10)
					this.set_pos_y(1);					
			}	
			break;
			
		default:
			System.out.println("invalid move");
		}

		// DEBUG, find out the current player coordinate
		output = "Player coordinate after move: ";
		output += this.get_pos_x() + "," + this.get_pos_y() + "\n";
		System.out.println(output);
	}
	
	static Board board;
	static GameState gamestate;
	int dimensions = 11;
	
	public boolean check_move(int x, int y) 
	{
		/*
		 * Check to see if this coordinate is valid 
		 * e.g. When moving from (5,1) to (5,9) via teleport, 
		 * Check if (5,9) exists as a coordinate (not -1) and 
		 * does not contain a player.
		 */
		
		// TODO BETTER OFF WITH GETTERS OR SEOMTHING
		gamestate = GameState.get_instance();
		board = gamestate.get_board();		
		board.create_associative_array();
		
		int[][] board_array = new int[dimensions][dimensions];
		
		board_array = board.get_board_array();
				
		// If player hits a wall, return false
		if (board_array[x][y] == -1)
		{
			System.out.println("Hitting a wall");
			return false;
		}	
		
		return true;
	}

	public int get_dir() 
	{
		return direction;
	}

	public void set_dir(int dir) 
	{
		this.direction = dir;
	}

	public int get_ddir() 
	{
		return desired_direction;
	}

	public void set_ddir(int ddir) 
	{
		this.desired_direction = ddir;
	}

	public int get_pos_x() 
	{
		return this.pos_x;
	}

	public void set_pos_x(int pos_x) 
	{
		this.pos_x = pos_x;
	}

	public int get_pos_y() 
	{
		return this.pos_y;
	}

	public void set_pos_y(int pos_y) 
	{
		this.pos_y = pos_y;
	}
}