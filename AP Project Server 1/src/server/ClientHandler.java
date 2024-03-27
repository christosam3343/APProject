package server;

import generalinfo.Staff;
import configureStreams.Server;
//Class for handling client requests
class ClientHandler implements Runnable {

    @Override
    public void run() {
        String action;
        Staff staff;
        configureStreams();
        try {
            action = (String) objIs.readObject();
//            logger.info("Requested action: " + action);
//            mainScreen.setRequestsText(requestAmount++);
//            mainScreen.setTextArea("\nRequested action: " + action);
//            mainScreen.setTextArea("\nHandled on: " + Thread.currentThread().getName() + "\n\n");
            if (action.equals("Add Employee")) {
                staff = (Staff) objIs.readObject();
                addEmployeeData(employee);
            }
//            if (action.equals("Update Employee")) {
//                employee = (Employee) objIs.readObject();
//                updateEmployeeData(employee);
//            }
//            if (action.equals("View Employees")) {
//                List<Employee> employeeList = getEmployeeList();
//                for (Employee emp : employeeList) {
//                    objOs.writeObject(emp);
//                }
//            }
//            if (action.equals("Find Employee")) {
//                String employeeId = (String) objIs.readObject();
//                employee = getEmployeeData(employeeId);
//                objOs.writeObject(employee);
//            }
//            if (action.equals("Remove Employee")) {
//                String employeeId = (String) objIs.readObject();
//                removeEmployeeData(employeeId);
//            }
//            if (action.equals("Add Customer")) {
//                customer = (Customer) objIs.readObject();
//                addCustomerData(customer);
//            }
//            if (action.equals("Update Customer")) {
//                customer = (Customer) objIs.readObject();
//                updateCustomerData(customer);
//            }
//            if (action.equals("View Customers")) {
//                List<Customer> customerList = getCustomerList();
//                for (Customer cus : customerList) {
//                    objOs.writeObject(cus);
//                }
//            }
//            if (action.equals("Find Customer")) {
//                String customerId = (String) objIs.readObject();
//                customer = getCustomerData(customerId);
//                objOs.writeObject(customer);
//            }
//            if (action.equals("Remove Customer")) {
//                String customerId = (String) objIs.readObject();
//                removeCustomerData(customerId);
//            }
//            if (action.equals("Add Product")) {
//                product = (Product) objIs.readObject();
//                addProductData(product);
//            }
//            if (action.equals("Update Product")) {
//                product = (Product) objIs.readObject();
//                updateProductData(product);
//            }
//            if (action.equals("Find Product")) {
//                String productCode = (String) objIs.readObject();
//                product = getProductData(productCode);
//                objOs.writeObject(product);
//            }
//            if (action.equals("Remove Product")) {
//                String productCode = (String) objIs.readObject();
//                removeProductData(productCode);
//            }
//            if (action.equals("View Products")) {
//                List<Product> productList = getProductList();
//                for (Product prod : productList) {
//                    objOs.writeObject(prod);
//                }
//            }
//            if (action.equals("Add Invoice")) {
//                invoice = (Invoice) objIs.readObject();
//                addInvoiceData(invoice);
//            }
//            if (action.equals("View Invoices")) {
//                List<Invoice> invoiceList = getInvoiceList();
//                for (Invoice inv : invoiceList) {
//                    objOs.writeObject(inv);
//                }
//            }
//            if (action.equals("Find Invoice")) {
//                int invoiceNum = (int) objIs.readObject();
//                invoice = getInvoiceData(invoiceNum);
//                objOs.writeObject(invoice);
//            }
//            if (action.equals("Remove Invoice")) {
//                int invoiceNum = (int) objIs.readObject();
//                removeInvoiceData(invoiceNum);
//            }
//            if (action.equals("Add Purchase")) {
//                List<Purchase> purchaseList = (List<Purchase>) objIs.readObject();
//                addPurchaseData(purchaseList);
//            }
//            if (action.equals("View Purchase")) {
//                int invoiceNum = (int) objIs.readObject();
//                List<Purchase> purchaseList = getPurchaseList(invoiceNum);
//                for (Purchase itemList : purchaseList) {
//                    objOs.writeObject(itemList);
//                }
//            }
//            if (action.equals("Update Inventory")) {
//                List<Inventory> inventoryList = (List<Inventory>) objIs.readObject();
//                updateInventoryData(inventoryList);
//            }
//            if (action.equals("View Inventory Item")) {
//                InventoryId inventoryId = (InventoryId) objIs.readObject();
//                inventory = getInventoryItem(inventoryId);
//                objOs.writeObject(inventory);
//            }
        } catch (EOFException e) {
            logger.error("EOFException: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("IOException: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            logger.error("ClassNotFoundException: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassCastException e) {
            logger.error("ClassCastException: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnections();
        }
    }
}