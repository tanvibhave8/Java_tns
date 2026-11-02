
package com.microwarehouse.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.microwarehouse.entity.Product;
import com.microwarehouse.repository.ReportRepository;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    // 1. Get Low Stock Alerts
    public List<Product> getLowStockAlerts(int threshold) {

        if (threshold < 0) {
            throw new IllegalArgumentException(
                    "Threshold cannot be negative");
        }

        return reportRepository.getLowStockProducts(threshold);
    }

    // 2. Get Total Fulfillment Revenue
    public BigDecimal getTotalRevenue() {

        return reportRepository.getTotalRevenue();
    }

    // 3. Get Top Selling Products
    public List<Map<String, Object>> getTopSellingProducts() {

        return reportRepository.getTopSellingProducts();
    }
}
