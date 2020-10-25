package net.steelphoenix.chatgames.api.game;

import java.util.UUID;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface IGame {
	/**
	 * Get this game's question.
	 * @return this game's question.
	 */
	@NotNull
	public Question getQuestion();
	/**
	 * Get the starting time of this game.
	 * @return the start time as UNIX timestamp.
	 */
	public long getStartTime();
	/**
	 * Check if this game is still active.
	 * @return true if this game is still active (winnable)
	 */
	public boolean isActive();
	/**
	 * Deactivate this game.
	 * Makes it unwinnable.
	 */
	public void setInactive();
	/**
	 * Adds a winner.
	 * Deactivates this game when the 3rd player wins
	 * Deactivating it makes it unwinnable.
	 * @param player the UUID of the Player that wins
	 * @return the position of the winner, 0 if he already won
	 */
	public int setWinner(@NotNull UUID player, int maxWinners);
	/**
	 * End this game.
	 */
	@Contract("!isActive() -> NOP")
	public void end();
}
