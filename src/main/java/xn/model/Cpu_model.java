package xn.model;

public class Cpu_model{
	String L1d_cache;
	String L1i_cache;
	String L2_cache;
	String L3_cache;
	String model_name;////型号名称
	int Sockets;//	查看物理CPU的个数()实际Server中插槽上的CPU个数
	int processor;////查看逻辑CPU的个数
	double cpu_MHz;//CPU的实际使用主频
	
	
	String CPUtime;//cpu运行时间
	double KiBUsage;//内存使用率
	double cpuUsage;//Cpu使用率
	int Threads;//线程个数
	int losfnum;//句柄个数
	int Allprocess;//当前系统进程总数
	int P_running;//当前运行中的进程数
	int P_sleeping;//当前处于等待状态中的进程数
	int P_stopped;//被停止的系统进程数
	int P_zombie;//被复原的进程数
	
	
	
	
	
	
	
	public String getL1d_cache() {
		return L1d_cache;
	}
	public void setL1d_cache(String l1d_cache) {
		L1d_cache = l1d_cache;
	}
	public String getL1i_cache() {
		return L1i_cache;
	}
	public void setL1i_cache(String l1i_cache) {
		L1i_cache = l1i_cache;
	}
	public String getL2_cache() {
		return L2_cache;
	}
	public void setL2_cache(String l2_cache) {
		L2_cache = l2_cache;
	}
	public String getL3_cache() {
		return L3_cache;
	}
	public void setL3_cache(String l3_cache) {
		L3_cache = l3_cache;
	}
	public String getModel_name() {
		return model_name;
	}
	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}
	public int getSockets() {
		return Sockets;
	}
	public void setSockets(int sockets) {
		Sockets = sockets;
	}
	public int getProcessor() {
		return processor;
	}
	public void setProcessor(int processor) {
		this.processor = processor;
	}
	public double getCpu_MHz() {
		return cpu_MHz;
	}
	public void setCpu_MHz(double cpu_MHz) {
		this.cpu_MHz = cpu_MHz;
	}
	public String getCPUtime() {
		return CPUtime;
	}
	public void setCPUtime(String cPUtime) {
		CPUtime = cPUtime;
	}
	public double getKiBUsage() {
		return KiBUsage;
	}
	public void setKiBUsage(double kiBUsage) {
		KiBUsage = kiBUsage;
	}
	public double getCpuUsage() {
		return cpuUsage;
	}
	public void setCpuUsage(double cpuUsage) {
		this.cpuUsage = cpuUsage;
	}
	public int getThreads() {
		return Threads;
	}
	public void setThreads(int threads) {
		Threads = threads;
	}
	public int getLosfnum() {
		return losfnum;
	}
	public void setLosfnum(int losfnum) {
		this.losfnum = losfnum;
	}
	public int getAllprocess() {
		return Allprocess;
	}
	public void setAllprocess(int allprocess) {
		Allprocess = allprocess;
	}
	public int getP_running() {
		return P_running;
	}
	public void setP_running(int p_running) {
		P_running = p_running;
	}
	public int getP_sleeping() {
		return P_sleeping;
	}
	public void setP_sleeping(int p_sleeping) {
		P_sleeping = p_sleeping;
	}
	public int getP_stopped() {
		return P_stopped;
	}
	public void setP_stopped(int p_stopped) {
		P_stopped = p_stopped;
	}
	public int getP_zombie() {
		return P_zombie;
	}
	public void setP_zombie(int p_zombie) {
		P_zombie = p_zombie;
	}
	
	
	
	
}