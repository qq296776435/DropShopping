package com.jnucst2015.dropshopping.repository;

import com.jnucst2015.dropshopping.entity.SaleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

public interface SaleInfoRepository extends JpaRepository<SaleInfo, Integer> {

    SaleInfo findSaleInfoById(Integer id);
    List<SaleInfo> findSaleInfoBySellerId(Integer sellerId);
    List<SaleInfo> findSaleInfoByCompanyId(Integer companyId);

    @Query(value = "SELECT s.id,s.name FROM shop as s WHERE s.seller_id = ?1",nativeQuery = true)
    List<Map<String, Object>> queryShopList(int sellerId);

    List<SaleInfo> findSaleInfosByStateEqualsAndSellerIdEquals(int state, Integer sellerId);

    List<SaleInfo> findSaleInfosBySellerIdEquals(Integer sellerId);



    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE sale_info SET state = 0 WHERE id = ?1",nativeQuery = true)
    void daSale(int id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE sale_info SET state = 1 WHERE id = ?1",nativeQuery = true)
    void onSale(int id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE sale_info SET name = ?1, description = ?2, price = ?3 WHERE id=?4",nativeQuery = true)
    void updateSaleInfo(String name, String description, Integer price, Integer saleInfoId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE mvo_commodity SET quantity = quantity - ?1 WHERE id=?2",nativeQuery = true)
    void reduceCommodityQuantity(Integer quantity, Integer id );


}
