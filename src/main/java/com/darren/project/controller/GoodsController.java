package com.darren.project.controller;

import com.darren.project.dto.AddGoodsRequest;
import com.darren.project.dto.GoodsQueryParams;
import com.darren.project.dto.GoodsRequest;
import com.darren.project.entity.Goods;
import com.darren.project.service.GoodsService;
import com.darren.project.util.Page;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goods_detail")
    public ModelAndView getGoods(@RequestParam("goodsId") Integer goodsId, Model model) {
        Goods goods = goodsService.getGoodsById(goodsId);

        if (goods != null) {
            String imagePath = "/goods_images/" + goods.getImage();
            model.addAttribute("goods", goods);
            model.addAttribute("imagePath", imagePath);
            return new ModelAndView("goods_detail");
        } else {
            return new ModelAndView("error", "message", "商品不存在");
        }
    }

    @PostMapping("goods")
    public ResponseEntity<Goods> createGoods(@RequestBody @Valid GoodsRequest goodsRequest) {
        Integer goodsId = goodsService.createGoods(goodsRequest);

        Goods goodsById = goodsService.getGoodsById(goodsId);

        if (goodsById != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(goodsById);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @DeleteMapping("goods/{goodsId}")
    public ResponseEntity<Void> deleteGoods(@PathVariable Integer goodsId) {
        goodsService.deleteGoodsById(goodsId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("goods/{goodsId}")
    public ResponseEntity<Goods> updateGoods(@PathVariable Integer goodsId,
                                             @RequestBody @Validated GoodsRequest goodsRequest) {
        Goods goods = goodsService.getGoodsById(goodsId);

        if (goods == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            goodsService.updateGoods(goodsId, goodsRequest);
            Goods updateGoods = goodsService.getGoodsById(goodsId);
            return ResponseEntity.status(HttpStatus.OK).body(updateGoods);
        }
    }

    @GetMapping("goods")
    public ResponseEntity<Page<Goods>> getGoods(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "id") String orderBy,
            @RequestParam(defaultValue = "8") @Max(100) @Min(0) Integer limit,
            @RequestParam(defaultValue = "1") @Max(1000) @Min(0) Integer page) {
        GoodsQueryParams params = new GoodsQueryParams();

        int offset = (page - 1) * limit;
        params.setLimit(limit);
        params.setOffset(offset);
        params.setSearch(search);
        params.setOrderBy(orderBy);
        params.setSort(sort);

        //取得List
        List<Goods> goodsList = goodsService.getGoods(params);

        Integer total = goodsService.countGoods(params);

        Page<Goods> resultPage = new Page<>();
        resultPage.setLimit(limit);
        resultPage.setOffset(offset);
        resultPage.setTotal(total);
        resultPage.setResult(goodsList);
        return ResponseEntity.status(HttpStatus.OK).body(resultPage);
    }

    @PostMapping("goods/add")
    public ResponseEntity<Double>  addGoodsRequest(@RequestBody @Valid AddGoodsRequest addGoodsRequest, HttpSession session) {
        Integer goodsId = addGoodsRequest.getGoodsId();
        Goods goods = goodsService.getGoodsById(goodsId);

        if (goods == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<AddGoodsRequest> cart = (List<AddGoodsRequest>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        //防止商品重複添加(已存在商品數量+1)
        for (AddGoodsRequest item : cart) {
            if (item.getGoodsId().equals(goodsId)) {
                item.setQuantity(item.getQuantity() + 1);
                session.setAttribute("cart", cart);
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        }
        System.out.println("Current cart in session: " + session.getAttribute("cart"));
        addGoodsRequest.setGoodsId(goodsId);
        addGoodsRequest.setGoodsName(goods.getName());
        addGoodsRequest.setGoodsPrice(goods.getPrice());
        addGoodsRequest.setQuantity(1);
        cart.add(addGoodsRequest);

        System.out.println(addGoodsRequest.toString());

        session.setAttribute("cart", cart);

            return ResponseEntity.ok(calculateTotalPrice(cart));
        }

        private Double calculateTotalPrice(List<AddGoodsRequest> cart) {
            Double totalPrice = 0.0;
            for (AddGoodsRequest item : cart) {
                totalPrice += item.getQuantity() * item.getGoodsPrice();
            }
            return totalPrice;
        }

    @GetMapping("/cart")
    public ModelAndView getCart(HttpSession session) {
        List<AddGoodsRequest> cart = (List<AddGoodsRequest>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        ModelAndView modelAndView = new ModelAndView("cart");
        modelAndView.addObject("cartrow", cart);
        return modelAndView;
    }

    }


