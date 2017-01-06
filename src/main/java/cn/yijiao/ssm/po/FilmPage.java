package cn.yijiao.ssm.po;

public class FilmPage {
	@Override
	public String toString() {
		return "FilmPage [pageNum=" + pageNum + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", startNum="
				+ startNum + ", film=" + film + "]";
	}
	private int pageNum=1;
	private int pageSize;
	private int totalCount;
	private int startNum;
	private Film film;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
}