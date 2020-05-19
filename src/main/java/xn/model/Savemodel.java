package xn.model;

public class Savemodel {
	private  double neicunuse;//内存使用
	private  double neicunall;//内存总量
	private  double swap_all;//交换区大小
	private  double swap_use;//交换区已使用
	private  double swap_nei_result;//交换区使用率
	private  double all_nei_result;//内存使用率

	private  double shared1;//共享内存，一般系统不会用到，这里也不讨论
	private  double buffers1;//系统分配但未被使用的buffers 数量
	private  double cached1;//系统分配但未被使用的cache 数量。buffer 与cache 的区别见后面。
	
	public double getShared1() {
		return shared1;
	}
	public void setShared1(double shared1) {
		this.shared1 = shared1;
	}
	public double getBuffers1() {
		return buffers1;
	}
	public void setBuffers1(double buffers1) {
		this.buffers1 = buffers1;
	}
	public double getCached1() {
		return cached1;
	}
	public void setCached1(double cached1) {
		this.cached1 = cached1;
	}
	public double getNeicunuse() {
		return neicunuse;
	}
	public void setNeicunuse(double neicunuse) {
		this.neicunuse = neicunuse;
	}
	public double getNeicunall() {
		return neicunall;
	}
	public void setNeicunall(double neicunall) {
		this.neicunall = neicunall;
	}
	public double getSwap_all() {
		return swap_all;
	}
	public void setSwap_all(double swap_all) {
		this.swap_all = swap_all;
	}
	public double getSwap_use() {
		return swap_use;
	}
	public void setSwap_use(double swap_use) {
		this.swap_use = swap_use;
	}
	public double getSwap_nei_result() {
		return swap_nei_result;
	}
	public void setSwap_nei_result(double swap_nei_result) {
		this.swap_nei_result = swap_nei_result;
	}
	public double getAll_nei_result() {
		return all_nei_result;
	}
	public void setAll_nei_result(double all_nei_result) {
		this.all_nei_result = all_nei_result;
	}
	
	

}
