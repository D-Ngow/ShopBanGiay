/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.CalamDAO;
import DAO.DonhangDAO;
import DAO.GiohangDAO;
import DAO.KhachHangDAO;
import DAO.NhanvienDAO;
import DAO.SanphamDAO;
import ENTITY.Donhang;
import ENTITY.Giohang;
import ENTITY.Nhanvien;
import ENTITY.calam;
import ENTITY.khachhang;
import ENTITY.sanpham;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TrangAdmin extends javax.swing.JFrame {
    public boolean vt;
    public TrangAdmin(boolean vt) {
        initComponents();
        this.vt=vt;
        loadnv();
        loadsanpham();
        loadkhach();
        loadcalam();
        loadhd();
        loaddt();
        pnsanpham.setVisible(false);
        pncalam.setVisible(false);
        pndskhach.setVisible(false);
        pndshd.setVisible(false);
        pndoanhthu.setVisible(false);

    }

    private TrangAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    public void loadnv() {
        DefaultTableModel tbmode = (DefaultTableModel) tbnv.getModel();
        tbmode.setRowCount(0);
        NhanvienDAO nvd = new NhanvienDAO();
        List<Nhanvien> list1 = nvd.selectall();
        for (Nhanvien x : list1) {
            Object[] ob = {x.getMnv(), x.getHo(), x.getTen(), x.getEmail(), x.getSdt(), x.gioitinh, x.getDiachi(), x.trangthai, x.getNgaybatdau(), x.getNgayketthuc()};
            tbmode.addRow(ob);
            tbnv.setModel(tbmode);
        }
    }

    public void loadsanpham() {
        DefaultTableModel tbmode = (DefaultTableModel) tbsp.getModel();
        tbmode.setRowCount(0);
        SanphamDAO spd = new SanphamDAO();
        List<sanpham> listsp = spd.selectall();
        for (sanpham x : listsp) {
            Object[] obj = {x.getMsp(), x.getTsp(), x.getGia(), x.getMota(), x.getSoluong(), x.getHinhanh(), x.trangthai};
            tbmode.addRow(obj);
            tbsp.setModel(tbmode);
        }
    }

    public void loadcalam() {
        DefaultTableModel tbmode = (DefaultTableModel) tbcalam.getModel();
        tbmode.setRowCount(0);
        CalamDAO cld = new CalamDAO();
        List<calam> listcl = cld.selectall();
        for (calam x : listcl) {
            Object ob[] = {x.getCalam(), x.getMnv()};
            tbmode.addRow(ob);
            tbcalam.setModel(tbmode);
        }
    }

    public void loadkhach() {
        DefaultTableModel tbmode = (DefaultTableModel) tbdskhach.getModel();
        tbmode.setRowCount(0);
        KhachHangDAO k1dao = new KhachHangDAO();
        List<khachhang> list1 = k1dao.selectall();
        for (khachhang x : list1) {
            Object[] ob = {x.getMakhach(), x.getTenkhach(), x.getDiachi(), x.getSdt(), x.getEmail()};
            tbmode.addRow(ob);
            tbdskhach.setModel(tbmode);
        }
    }

    public void loadhd() {
        DefaultTableModel tbmode = (DefaultTableModel) tbhd.getModel();
        tbmode.setRowCount(0);
        DonhangDAO dhd = new DonhangDAO();
        List<Donhang> list1 = dhd.selectall();
        for (Donhang x : list1) {
            Object[] ob = {x.getMhd(), x.getNgayxuat(), x.getMnv(), x.getMak()};
            tbmode.addRow(ob);
            tbhd.setModel(tbmode);
        }
    }

    public void themcalam() {
        calam cl1 = new calam();
        cl1.setCalam(Date.valueOf(tftg.getText()));
        cl1.setMnv(Integer.parseInt(tfmnv.getText()));
        CalamDAO cld = new CalamDAO();
        cld.insert(cl1);
        JOptionPane.showMessageDialog(this, "Thêm ca làm thành công");
    }

    public void suacalam() {
        calam cl1 = new calam();
        cl1.setCalam(Date.valueOf(tftg.getText()));
        cl1.setMnv(Integer.parseInt(tfmnv.getText()));
        CalamDAO cld = new CalamDAO();
        cld.update(cl1);
        JOptionPane.showMessageDialog(this, "Sửa ca làm thành công");
    }

    public void xoacalam() {
        calam cl1 = new calam();
        cl1.setCalam(Date.valueOf(tftg.getText()));
        cl1.setMnv(Integer.parseInt(tfmnv.getText()));
        CalamDAO cld = new CalamDAO();
        cld.delete(cl1);
        JOptionPane.showMessageDialog(this, "Xóa ca làm thành công");
    }

    public void loaddt() {
        DefaultTableModel tbmode = (DefaultTableModel) tbdoanhthu.getModel();
        tbmode.setRowCount(0);
        DonhangDAO dhd = new DonhangDAO();
        GiohangDAO ghd = new GiohangDAO();
        List<Donhang> list1 = dhd.selectall();
        double tonghd = 0;
        for (Donhang x : list1) {
            List<Giohang> list2 = ghd.timtong(x.getMhd());
            double tong = 0;
            for (Giohang g : list2) {
                tong+= g.getSoluong() * g.getGia();
            }
            Object[] ob = {x.getMhd(), x.getNgayxuat(), x.getMnv(), x.getMak(), tong};
            tbmode.addRow(ob);
            tbdoanhthu.setModel(tbmode);
            tonghd+=tong;
        }
        lbtong.setText("Tổng doanh thu:"+tonghd+"VND");
    }
    
    public void loaddtt(){
    DefaultTableModel tbmode = (DefaultTableModel) tbdoanhthu.getModel();
        tbmode.setRowCount(0);
        DonhangDAO dhd = new DonhangDAO();
        GiohangDAO ghd = new GiohangDAO();
        List<Donhang> list1 = dhd.seachmonth(Integer.parseInt(tfmon.getText()));
        double tonghd = 0;
        for (Donhang x : list1) {
            List<Giohang> list2 = ghd.timtong(x.getMhd());
            double tong = 0;
            for (Giohang g : list2) {
                tong+= g.getSoluong() * g.getGia();
            }
            Object[] ob = {x.getMhd(), x.getNgayxuat(), x.getMnv(), x.getMak(), tong};
            tbmode.addRow(ob);
            tbdoanhthu.setModel(tbmode);
        tonghd+=tong;
        }
        lbtong.setText("Tổng doanh thu:"+tonghd+"VND");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        jMenu1 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        btndoanhthu = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        btndoanhthu1 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        pndsnv = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbnv = new javax.swing.JTable();
        btnthemkhach = new javax.swing.JButton();
        pnsanpham = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbsp = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        pncalam = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbcalam = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tftg = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfmnv = new javax.swing.JTextField();
        btnthemkhach1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        pndskhach = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbdskhach = new javax.swing.JTable();
        btnthemkhach2 = new javax.swing.JButton();
        pndshd = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbhd = new javax.swing.JTable();
        pndoanhthu = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbdoanhthu = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        tfmon = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        lbtong = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        jMenu1.setText("jMenu1");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Clien list.png"))); // NOI18N
        jButton7.setText("Quản lý nhân viên");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Application form.png"))); // NOI18N
        jButton8.setText("Quản lý ca làm");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Box.png"))); // NOI18N
        jButton9.setText("Quản lý sản phẩm");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("MỤC LỤC");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Billboard.png"))); // NOI18N
        jButton3.setText("Quản lý đơn hàng");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Basket.png"))); // NOI18N
        jButton10.setText("Tạo đơn hàng");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/manager (1).png"))); // NOI18N
        jButton4.setText("Quản lý khách hàng");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btndoanhthu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Dollar.png"))); // NOI18N
        btndoanhthu.setText("Doanh thu");
        btndoanhthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndoanhthuActionPerformed(evt);
            }
        });

        btndoanhthu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Exit.png"))); // NOI18N
        btndoanhthu1.setText("Đăng xuất");
        btndoanhthu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndoanhthu1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator4)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator6)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(btndoanhthu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btndoanhthu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btndoanhthu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btndoanhthu1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pndsnv.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("DANH SÁCH NHÂN VIÊN");

        tbnv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ", "Tên", "Email", "SĐT", "Giới tính", "Địa chỉ", "Trạng thái", "Ngày bắt đầu ", "Ngày kết thúc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbnvMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbnvMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbnv);
        if (tbnv.getColumnModel().getColumnCount() > 0) {
            tbnv.getColumnModel().getColumn(3).setHeaderValue("Email");
            tbnv.getColumnModel().getColumn(4).setHeaderValue("SĐT");
            tbnv.getColumnModel().getColumn(5).setResizable(false);
            tbnv.getColumnModel().getColumn(5).setHeaderValue("Giới tính");
            tbnv.getColumnModel().getColumn(6).setHeaderValue("Địa chỉ");
            tbnv.getColumnModel().getColumn(7).setHeaderValue("Trạng thái");
            tbnv.getColumnModel().getColumn(9).setHeaderValue("Ngày kết thúc");
        }

        btnthemkhach.setText("Thêm");
        btnthemkhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemkhachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pndsnvLayout = new javax.swing.GroupLayout(pndsnv);
        pndsnv.setLayout(pndsnvLayout);
        pndsnvLayout.setHorizontalGroup(
            pndsnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndsnvLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pndsnvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pndsnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pndsnvLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnthemkhach, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        pndsnvLayout.setVerticalGroup(
            pndsnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndsnvLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnthemkhach)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnsanpham.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("DANH SÁCH SẢN PHẨM");

        tbsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá ", "Mô tả", "Số lượng", "Hình ảnh", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbspMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbsp);

        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnsanphamLayout = new javax.swing.GroupLayout(pnsanpham);
        pnsanpham.setLayout(pnsanphamLayout);
        pnsanphamLayout.setHorizontalGroup(
            pnsanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnsanphamLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnsanphamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1116, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnsanphamLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        pnsanphamLayout.setVerticalGroup(
            pnsanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnsanphamLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pncalam.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("QUẢN LÝ CA LÀM");

        tbcalam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ca làm", "Mã nhân viên"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbcalam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbcalamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbcalam);

        jLabel6.setText("Thời gian làm");

        jLabel7.setText("Mã nhân  viên");

        btnthemkhach1.setText("Thêm");
        btnthemkhach1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemkhach1ActionPerformed(evt);
            }
        });

        jButton1.setText("Sửa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setText("Xóa");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnthemkhach1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(tfmnv, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                        .addComponent(tftg)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tftg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfmnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthemkhach1)
                    .addComponent(jButton1)
                    .addComponent(jButton5))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pncalamLayout = new javax.swing.GroupLayout(pncalam);
        pncalam.setLayout(pncalamLayout);
        pncalamLayout.setHorizontalGroup(
            pncalamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pncalamLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pncalamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pncalamLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
                    .addGroup(pncalamLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pncalamLayout.setVerticalGroup(
            pncalamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pncalamLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGroup(pncalamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pncalamLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pncalamLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pndskhach.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("DANH SÁCH KHÁCH HÀNG");

        tbdskhach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã khách", "Tên khách", "Địa chỉ", "Số điện thoại", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbdskhach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbdskhachMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbdskhach);

        btnthemkhach2.setText("Thêm");
        btnthemkhach2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemkhach2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pndskhachLayout = new javax.swing.GroupLayout(pndskhach);
        pndskhach.setLayout(pndskhachLayout);
        pndskhachLayout.setHorizontalGroup(
            pndskhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndskhachLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pndskhachLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnthemkhach2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(pndskhachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE))
        );
        pndskhachLayout.setVerticalGroup(
            pndskhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndskhachLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnthemkhach2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pndshd.setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("DANH SÁCH HÓA ĐƠN");

        tbhd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Ngày xuất", "Mã nhân viên", "Mã khách"
            }
        ));
        tbhd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbhdMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbhdMouseEntered(evt);
            }
        });
        jScrollPane5.setViewportView(tbhd);

        javax.swing.GroupLayout pndshdLayout = new javax.swing.GroupLayout(pndshd);
        pndshd.setLayout(pndshdLayout);
        pndshdLayout.setHorizontalGroup(
            pndshdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndshdLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pndshdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1104, Short.MAX_VALUE)
                .addContainerGap())
        );
        pndshdLayout.setVerticalGroup(
            pndshdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndshdLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pndoanhthu.setBackground(new java.awt.Color(204, 204, 204));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("DOANH THU");

        tbdoanhthu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Ngày xuất", "Mã nhân viên", "Mã khách", "Tổng tiền"
            }
        ));
        tbdoanhthu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbdoanhthuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbdoanhthuMouseEntered(evt);
            }
        });
        jScrollPane7.setViewportView(tbdoanhthu);

        jLabel11.setText("Tìm kiếm theo tháng");

        jButton6.setText("Tìm kiếm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        lbtong.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout pndoanhthuLayout = new javax.swing.GroupLayout(pndoanhthu);
        pndoanhthu.setLayout(pndoanhthuLayout);
        pndoanhthuLayout.setHorizontalGroup(
            pndoanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndoanhthuLayout.createSequentialGroup()
                .addGroup(pndoanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pndoanhthuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1104, Short.MAX_VALUE))
                    .addGroup(pndoanhthuLayout.createSequentialGroup()
                        .addGroup(pndoanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pndoanhthuLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel10))
                            .addGroup(pndoanhthuLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfmon, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)
                                .addGap(104, 104, 104)
                                .addComponent(lbtong, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 153, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pndoanhthuLayout.setVerticalGroup(
            pndoanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndoanhthuLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pndoanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pndoanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(tfmon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pndsnv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(pnsanpham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(pncalam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(171, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(pndskhach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(6, 6, 6)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pndshd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pndoanhthu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pndsnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(67, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(pncalam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(68, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pndskhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(78, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pndshd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(55, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(pndoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(45, Short.MAX_VALUE)))
        );
        jLayeredPane1.setLayer(pndsnv, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(pnsanpham, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(pncalam, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(pndskhach, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(pndshd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(pndoanhthu, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/image(1246).png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        pndsnv.setVisible(true);
        pnsanpham.setVisible(false);
        pncalam.setVisible(false);
        pndskhach.setVisible(false);
        pndshd.setVisible(false);
        pndoanhthu.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
      
        pncalam.setVisible(true);
        pndsnv.setVisible(false);
        pnsanpham.setVisible(false);
        pndskhach.setVisible(false);
        pndshd.setVisible(false);
        pndoanhthu.setVisible(false);
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        pndsnv.setVisible(false);
        pnsanpham.setVisible(true);
        pncalam.setVisible(false);
        pndskhach.setVisible(false);
        pndshd.setVisible(false);
        pndoanhthu.setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnthemkhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemkhachActionPerformed
        // TODO add your handling code here:
        new ThemNhanVien().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnthemkhachActionPerformed

    private void tbnvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbnvMouseClicked
        // TODO add your handling code here:
        int indexnv = tbnv.getSelectedRow();
        Nhanvien nv = new Nhanvien();
        nv.setMnv((String) tbnv.getValueAt(indexnv, 0));
        nv.setHo((String) tbnv.getValueAt(indexnv, 1));
        nv.setTen((String) tbnv.getValueAt(indexnv, 2));
        nv.setEmail((String) tbnv.getValueAt(indexnv, 3));
        nv.setSdt((String) tbnv.getValueAt(indexnv, 4));
        nv.setGioitinh((boolean) tbnv.getValueAt(indexnv, 5));
        nv.setDiachi((String) tbnv.getValueAt(indexnv, 6));
        nv.setTrangthai((boolean) tbnv.getValueAt(indexnv, 7));
        nv.setNgaybatdau((Date) tbnv.getValueAt(indexnv, 8));
        nv.setNgayketthuc((Date) tbnv.getValueAt(indexnv, 9));
        SuaNhanVien nv1 = new SuaNhanVien(nv);
        nv1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tbnvMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new ThemSanPham().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbspMouseClicked
        // TODO add your handling code here:
        int indexsp = tbsp.getSelectedRow();
        sanpham sp = new sanpham();
        sp.setMsp((String) tbsp.getValueAt(indexsp, 0));
        sp.setTsp((String) tbsp.getValueAt(indexsp, 1));
        sp.setGia((double) tbsp.getValueAt(indexsp, 2));
        sp.setMota((String) tbsp.getValueAt(indexsp, 3));
        sp.setSoluong((int) tbsp.getValueAt(indexsp, 4));
        sp.setHinhanh((String) tbsp.getValueAt(indexsp, 5));
        sp.setTrangthai((boolean) tbsp.getValueAt(indexsp, 6));
        SuaSanPham ssp = new SuaSanPham(sp);
        ssp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tbspMouseClicked

    private void tbcalamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbcalamMouseClicked
        // TODO add your handling code here:
        int indexcl = tbcalam.getSelectedRow();
        calam c1 = new calam();
        c1.setCalam((Date) tbcalam.getValueAt(indexcl, 0));
        c1.setMnv((int) tbcalam.getValueAt(indexcl, 1));
        tfmnv.setText(String.valueOf(c1.getMnv()));
        tftg.setText(String.valueOf(c1.getCalam()));
    }//GEN-LAST:event_tbcalamMouseClicked

    private void btnthemkhach1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemkhach1ActionPerformed
        // TODO add your handling code here:
        themcalam();
        loadcalam();
    }//GEN-LAST:event_btnthemkhach1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        pndsnv.setVisible(false);
        pnsanpham.setVisible(false);
        pncalam.setVisible(false);
        pndskhach.setVisible(false);
        pndshd.setVisible(true);
        pndoanhthu.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        new Taohoadon(vt).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        pndsnv.setVisible(false);
        pnsanpham.setVisible(false);
        pncalam.setVisible(false);
        pndskhach.setVisible(true);
        pndshd.setVisible(false);
        pndoanhthu.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbdskhachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbdskhachMouseClicked
        // TODO add your handling code here:
        int indexc = tbdskhach.getSelectedRow();
        khachhang kh1 = new khachhang();
        kh1.setMakhach((String) tbdskhach.getValueAt(indexc, 0));
        kh1.setTenkhach((String) tbdskhach.getValueAt(indexc, 1));
        kh1.setDiachi((String) tbdskhach.getValueAt(indexc, 2));
        kh1.setSdt((String) tbdskhach.getValueAt(indexc, 3));
        kh1.setEmail((String) tbdskhach.getValueAt(indexc, 4));
        Suakhachhang skh1 = new Suakhachhang(kh1,vt);
        skh1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tbdskhachMouseClicked

    private void btnthemkhach2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemkhach2ActionPerformed
        // TODO add your handling code here:
        new Themkhachhang(vt).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnthemkhach2ActionPerformed

    private void tbnvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbnvMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbnvMouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        suacalam();
        loadcalam();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        xoacalam();
        loadcalam();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tbhdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbhdMouseClicked
        // TODO add your handling code here:
        int index = tbhd.getSelectedRow();
        Donhang dh = new Donhang();
        dh.setMhd((String) tbhd.getValueAt(index, 0));
        dh.setNgayxuat((Date) tbhd.getValueAt(index, 1));
        dh.setMnv((Integer) tbhd.getValueAt(index, 2));
        dh.setMak((Integer) tbhd.getValueAt(index, 3));
        new Suahoadon(dh).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tbhdMouseClicked

    private void tbhdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbhdMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbhdMouseEntered

    private void tbdoanhthuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbdoanhthuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbdoanhthuMouseClicked

    private void tbdoanhthuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbdoanhthuMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbdoanhthuMouseEntered

    private void btndoanhthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndoanhthuActionPerformed
        // TODO add your handling code here:
        pndsnv.setVisible(false);
        pnsanpham.setVisible(false);
        pncalam.setVisible(false);
        pndskhach.setVisible(false);
        pndshd.setVisible(false);
        pndoanhthu.setVisible(true);
    }//GEN-LAST:event_btndoanhthuActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        loaddtt();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btndoanhthu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndoanhthu1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Dangnhap().setVisible(true);
    }//GEN-LAST:event_btndoanhthu1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrangAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndoanhthu;
    private javax.swing.JButton btndoanhthu1;
    private javax.swing.JButton btnthemkhach;
    private javax.swing.JButton btnthemkhach1;
    private javax.swing.JButton btnthemkhach2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lbtong;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JPanel pncalam;
    private javax.swing.JPanel pndoanhthu;
    private javax.swing.JPanel pndshd;
    private javax.swing.JPanel pndskhach;
    private javax.swing.JPanel pndsnv;
    private javax.swing.JPanel pnsanpham;
    private javax.swing.JTable tbcalam;
    private javax.swing.JTable tbdoanhthu;
    private javax.swing.JTable tbdskhach;
    private javax.swing.JTable tbhd;
    private javax.swing.JTable tbnv;
    private javax.swing.JTable tbsp;
    private javax.swing.JTextField tfmnv;
    private javax.swing.JTextField tfmon;
    private javax.swing.JTextField tftg;
    // End of variables declaration//GEN-END:variables
}
