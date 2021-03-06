package jadx.core.dex.visitors.blocksmaker.helpers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jetbrains.annotations.Nullable;

import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.nodes.BlockNode;

public final class BlocksRemoveInfo {
	private final Set<BlocksPair> processed = new HashSet<>();
	private final Set<BlocksPair> outs = new HashSet<>();
	private final Map<RegisterArg, RegisterArg> regMap = new HashMap<>();

	private BlocksPair start;
	private BlocksPair end;

	private int startSplitIndex;
	private int endSplitIndex;

	private BlockNode startPredecessor;

	private boolean applied;

	public BlocksRemoveInfo(BlocksPair start) {
		this.start = start;
	}

	public Set<BlocksPair> getProcessed() {
		return processed;
	}

	public Set<BlocksPair> getOuts() {
		return outs;
	}

	public BlocksPair getStart() {
		return start;
	}

	public void setStart(BlocksPair start) {
		this.start = start;
	}

	public BlocksPair getEnd() {
		return end;
	}

	public void setEnd(BlocksPair end) {
		this.end = end;
	}

	public int getStartSplitIndex() {
		return startSplitIndex;
	}

	public void setStartSplitIndex(int startSplitIndex) {
		this.startSplitIndex = startSplitIndex;
	}

	public int getEndSplitIndex() {
		return endSplitIndex;
	}

	public void setEndSplitIndex(int endSplitIndex) {
		this.endSplitIndex = endSplitIndex;
	}

	public void setStartPredecessor(BlockNode startPredecessor) {
		this.startPredecessor = startPredecessor;
	}

	public BlockNode getStartPredecessor() {
		return startPredecessor;
	}

	public Map<RegisterArg, RegisterArg> getRegMap() {
		return regMap;
	}

	@Nullable
	public BlockNode getByFirst(BlockNode first) {
		for (BlocksPair blocksPair : processed) {
			if (blocksPair.getFirst() == first) {
				return blocksPair.getSecond();
			}
		}
		return null;
	}

	@Nullable
	public BlockNode getBySecond(BlockNode second) {
		for (BlocksPair blocksPair : processed) {
			if (blocksPair.getSecond() == second) {
				return blocksPair.getSecond();
			}
		}
		return null;
	}

	public boolean isApplied() {
		return applied;
	}

	public void setApplied(boolean applied) {
		this.applied = applied;
	}

	@Override
	public String toString() {
		return "BRI{start: " + start
				+ ", end: " + end
				+ ", processed: " + processed
				+ ", outs: " + outs
				+ ", regMap: " + regMap
				+ ", split: " + startSplitIndex + '-' + endSplitIndex
				+ '}';
	}
}
