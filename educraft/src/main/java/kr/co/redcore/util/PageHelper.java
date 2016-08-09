package kr.co.redcore.util;

import java.util.List;

public class PageHelper {
	public static final long DEFAULT_GROUP_SIZE = 10;
	public static final long DEFAULT_PAGE_SIZE = 10;

	private long currPage;
	private long groupSize;
	private long pageSize;
	private long totalRows;
	private List list;

	public PageHelper(long currPage) {
		this.currPage = currPage;
		this.groupSize = DEFAULT_GROUP_SIZE;
		this.pageSize = DEFAULT_PAGE_SIZE;
		this.totalRows = 0;
		this.list = null;
	}

	public PageHelper(long currPage, long groupSize, long pageSize) {
		this.currPage = currPage;
		this.groupSize = groupSize;
		this.pageSize = pageSize;
		this.totalRows = 0;
		this.list = null;
	}

	public boolean isFirstPage() {
		return (currPage == 1) ? true : false;
	}

	public boolean isLastPage() {
		return (currPage == getTotalPage()) ? true : false;
	}

	public long getTotalPage() {
		return (long) Math.ceil((double) totalRows / (double) pageSize);
	}

	public long getStartPage() {
		return (((currPage - 1) / groupSize) * groupSize) + 1;
	}

	public long getEndPage() {
		return (((getTotalPage() - 1) / groupSize) == ((currPage - 1) / groupSize)) ? getTotalPage() : ((((currPage - 1) / groupSize) * groupSize) + groupSize);
	}

	public boolean hasPrevBlock() {
		return (getStartPage() > 1) ? true : false;
	}

	public boolean hasNextBlock() {
		return (getEndPage() < getTotalPage()) ? true : false;
	}

	public long getStartRow() {
		return ((currPage - 1) * pageSize) + 1;
	}

	public long getEndRow() {
		return (currPage * pageSize) > totalRows ? totalRows : (currPage * pageSize);
	}

	public long getCurrPage() {
		return currPage;
	}

	public void setCurrPage(long currPage) {
		this.currPage = currPage;
	}

	public long getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(long groupSize) {
		this.groupSize = groupSize;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append(super.toString());
		sb.append("PageHelper value ( ");
		sb.append("totalRows=>" + totalRows + ", ");
		sb.append("totalPage=>" + getTotalPage() + ", ");
		sb.append("groupSize=>" + getGroupSize() + ", ");
		sb.append("pageSize=>" + getPageSize() + ", ");
		sb.append("currPage=>" + getCurrPage() + ", ");
		sb.append("startPage=>" + getStartPage() + ", ");
		sb.append("endPage=>" + getEndPage() + ", ");
		sb.append("startRow=>" + getStartRow() + ", ");
		sb.append("endRow=>" + getEndRow() + " ) ");

		return sb.toString();
	}
}
