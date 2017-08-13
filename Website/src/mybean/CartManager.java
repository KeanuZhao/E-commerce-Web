package mybean;

import java.util.*;


public class CartManager {
	
	public ArrayList<ItemBean> cart;
	
	
	public void setCart(ArrayList<ItemBean> cart){
		this.cart=cart;
	}
	
	
	public ArrayList<ItemBean> getCart(){
		return this.cart;
	}
	
	//�����Ʒ������
	public ArrayList<ItemBean> addToCart(GoodsBean g,int quantity){
		if(cart==null){
			cart=new ArrayList<ItemBean>();
			ItemBean item=new ItemBean(g,quantity);
			cart.add(item);
		}
		else{
			 Object items[]=cart.toArray();
			 boolean find=false;
			 for(int i=0;i<items.length;i++){
				 ItemBean temp=(ItemBean)items[i];
				 //�жϹ��ﳵ���Ƿ����Ҫ��ӵ���Ʒ
				 if(temp.getGoods().getCid().equals(g.getCid())){
					 temp.setQuantity(temp.getQuantity()+quantity);
					 find=true;
					 break;
				 }
			 }
			 if(!find){
				 //��ӵ����ﳵ
				 ItemBean item=new ItemBean(g,quantity);
				 cart.add(item);
			 }
		}
		return cart;
	}
	public void update(String cid, int quantity){
		//�����ﳵcartתΪ���ڱ�����Iterator����i
		Iterator<ItemBean> i=cart.iterator();
		//�����������Ƿ����Ԫ��
		while(i.hasNext()){
			ItemBean temp=i.next();
			//���������еı��Ϊcid����Ʒ�����Ƿ���ڡ�  
			if(temp.getGoods().getCid().equals(cid)){
				//�޸�����
				temp.setQuantity(quantity);
				break;
			}				
			
		}
	}
	public void delete(String cid){
		Iterator<ItemBean> i=cart.iterator();
		while(i.hasNext()){
			ItemBean temp=i.next();
			if(temp.getGoods().getCid().equals(cid)){
				cart.remove(temp);
				break;
			}
		}
	}


}
