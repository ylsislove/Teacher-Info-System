# -*- coding:utf-8 -*-
#
# @author Apple_Coco
# @date 2019/9/25 21:03:09
# @description
#
# {"userId":"00011","department":"软工系","username":"王宇11","sex":"男","enname":"yain","birth":"2019-09-05","worktime":"2019-09-03","parttime":"2019-09-10","titletime":"2019-07","position":"院长","title":"教授","worktype":"教学型","worklevel":"3","honorarytitle":"","parttimejob":"","email":""}

import xlrd
import json
from collections import OrderedDict

# 设置输入文件的路径
path = 'C:/Users/Apple_Coco/Desktop/user.xlsx'

# 设置输出文件的路径
out_path = 'user.json'

column_index = ['工号', '单位', '姓名', '性别', '英文名', '出生年月', '参加工作时间', '入党时间', '评职时间', '职务',
                '职称', '岗位类别', '岗位等级', '个人荣誉称号', '社会与学术兼职', '常用邮箱']

# 规范列名
norm_column_name = {
    '工号': -1,
    '单位': -1,
    '姓名': -1,
    '性别': -1,
    '英文名': -1,
    '出生年月': -1,
    '参加工作时间': -1,
    '入党时间': -1,
    '评职时间': -1,
    '职务': -1,
    '职称': -1,
    '岗位类别': -1,
    '岗位等级': -1,
    '个人荣誉称号': -1,
    '社会与学术兼职': -1,
    '常用邮箱': -1,
}

mapping = {
    '工号': 'userId',
    '单位': 'department',
    '姓名': 'username',
    '性别': 'sex',
    '英文名': 'enname',
    '出生年月': 'birth',
    '参加工作时间': 'worktime',
    '入党时间': 'parttime',
    '评职时间': 'titletime',
    '职务': 'position',
    '职称': 'title',
    '岗位类别': 'worktype',
    '岗位等级': 'worklevel',
    '个人荣誉称号': 'honorarytitle',
    '社会与学术兼职': 'parttimejob',
    '常用邮箱': 'email',
}

# 打开execl
workbook = xlrd.open_workbook(path)

# 输出Excel文件中所有sheet的名字
# print(workbook.sheet_names())

# 根据sheet索引或者名称获取sheet内容
Data_sheet = workbook.sheets()[0]  # 通过索引获取

# print(Data_sheet.name)  # 获取sheet名称
rowNum = Data_sheet.nrows  # sheet行数
colNum = Data_sheet.ncols  # sheet列数
realNum = len(column_index)

# 首先规范列名
for j in range(colNum):
    if Data_sheet.cell_value(0, j) in norm_column_name.keys():
        # 排好序
        norm_column_name[Data_sheet.cell_value(0, j)] = j

# 获取所有单元格的内容
list = []
for i in range(1, rowNum):
    rowlist = OrderedDict()
    for j in range(realNum):
        mapping_name = mapping[column_index[j]]
        real_index = norm_column_name[column_index[j]]
        if real_index == -1:
            rowlist[mapping_name] = ""
        else:
            rowlist[mapping_name] = Data_sheet.cell_value(i, real_index)
    list.append(rowlist)

# 输出到json文件
with open(out_path, 'w', encoding='utf-8') as f_six:
    for i in range(rowNum-1):
        json.dump(list[i], f_six, ensure_ascii=False)
        f_six.write('\n')
    print("写入完成")