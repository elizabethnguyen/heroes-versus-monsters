import java.util.*;

public abstract class Monster extends DungeonCharacter
{
    // members
    protected double _heal_chance;
    protected int _max_heal;
    protected int _min_heal;

    // name: constructor
    // desc: passes scan and gen to the parent
    // params: Scanner scan, Random gen
    // return: n/a
    // 1) super(scan, gen);

    public Monster(Scanner scan, Random gen)
    {
	super(scan, gen);
    }

    // name: attack (OVERRIDE)
    // desc: the monster attacks the hero based on _hit_chance
    // params: Hero enemy
    // return: void
    // 1) chance = _gen.nextDouble();
    // 2) if (chance <= _hit_chance)

    public void attack(Hero enemy)
    {
	double chance;
	int damage;

	if (_hit_points <= 0)
	    return;

	if ( enemy._hit_points <= 0)
	    return;

	chance = _gen.nextDouble();

	if (chance <= _hit_chance)
	    {
		damage = Math.abs(_gen.nextInt(_max_dmg - _min_dmg) + _min_dmg);
		System.out.println(_name + " the " + _class_type + " deals " + damage + " points of damage!");
		enemy.take_damage(damage);
	    }
	else
	    {
		System.out.println( _name + " the " + _class_type + "'s attack missed!");
		System.out.println(enemy.toString());
	    }

    }

    // name: take_damage (OVERRIDE)
    // desc: The monster has a chance to heal if he is about to take damage.
    // params: int damage
    // return: void
    // 1) chance = _gen.nextDouble();
    // 2) if (chance <= _heal_chance)

    public void take_damage(int damage)
    {
	super.take_damage(damage);
	attempt_heal();
    }

    // name: attempt_heal
    // desc: Allows the monster to try and heal based on _heal_chance
    // params: none
    // return: void
    // 1) change = _gen.nextDouble();
    // 2) if (chance <= _heal_chance)

    public void attempt_heal()
    {
	double chance;
	int heal;

	if (_hit_points <= 0)
	    return;

	chance = _gen.nextDouble();

	if (chance <= _heal_chance)
	    {
		heal = _gen.nextInt(_max_heal - _min_dmg) + _min_dmg;
		System.out.println("The " + _class_type + " heals for " + heal + " points of damage!");
		_hit_points += heal;
		System.out.println(toString());
	    }
    }

    // name: reset_for_game (ABSTRACT)
    // desc: an abstract method to allow characters to reset their health for
    // a new game
    // params: none
    // return: void

    public abstract void reset_for_game();

}
