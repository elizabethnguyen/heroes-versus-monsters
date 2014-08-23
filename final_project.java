import java.util.*;

public class final_project
{
    public static void main(String[] args)
    {
	HeroesVersusMonsters game;
	game = new HeroesVersusMonsters();

	game.play_game();

	while (game.play_again())
		game.play_game();
    }
}
