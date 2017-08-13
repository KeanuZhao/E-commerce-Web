package mybean;



public class ItemBean {
		private GoodsBean goods;
		private int quantity;
		public ItemBean(GoodsBean g, int quantity){
			this.goods=g;
			this.quantity=quantity;
		}
		
		public void setGoods(GoodsBean goods){
			this.goods=goods;
		}
		public GoodsBean getGoods(){
			return this.goods;
		}
		public void setQuantity(int quantity){
			this.quantity=quantity;
		}
		public int getQuantity(){
			return this.quantity;
		}

}
