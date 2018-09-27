package com.example.sapplesystems.weather.helper_classes

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.sapplesystems.weather.helper_classes.MyDBHelper.Companion.SESSION_TABLE_NAME

import java.util.ArrayList

/**
 * Created by Gautam on 8/17/2016.
 */
class MyDBHelper
/**
 * Created by Gautam Anand
 *
 * @param context
 */
(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    var solId: String? = null
    private var context: Context? = null

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val applicantPrefix: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(APPLICANT_PREFIX_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(APPLICANT_PREFIX_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val accountType: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(ACCOUNT_TYPE_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(ACCOUNT_TYPE_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val marriedStatus: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(MARRIED_STATUS_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(MARRIED_STATUS_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val femaleTitle: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(FEMALE_TITLE_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(FEMALE_TITLE_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    val maleTitle: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(MALE_TITLE_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(MALE_TITLE_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val annualIncome: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(ANNUAL_INCOME_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(ANNUAL_INCOME_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val selfAnnualIncome: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(SELF_ANNUAL_INCOME_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(SELF_ANNUAL_INCOME_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val residenceType: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(RESIDENCE_TYPE_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(RESIDENCE_TYPE_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val bloodGroup: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(BLOOD_GROUP_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(BLOOD_GROUP_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val illness: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(ILLNESS_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(ILLNESS_GROUP_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val relationCardHolder: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(CARD_HOLDER_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(CARD_HOLDER_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val securities: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(SECURITIES_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(SECURITIES_NAME_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val addressProof: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(NOMINEE_ADDRESS_PROOF_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(NOMINEE_ADDRESS_PROOF_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val modeRights: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(MODE_RIGHTS_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(MODE_RIGHTS_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val sipDate: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(SIP_DATE_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(SIP_DATE_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val periods: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(PERIODS_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(PERIODS_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val pep: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(PEP_HOLDER_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(PEP_HOLDER_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val education: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(EDUCATION_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(EDUCATION_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val sourceofFunds: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(SOURCE_FUND_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(SOURCE_FUND_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val salaried: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(SALARIED_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(SALARIED_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val annualBusinessTurnover: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(ANNUAL_BUSINESS_TURNOVER_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(ANNUAL_BUSINESS_TURNOVER_INCOME_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    val addressType: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(ADDRESS_TYPE_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(ADDRESS_TYPE_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val relationWithDepositor: ArrayList<RelationWithDepositor>
        get() {
            val _array_list = ArrayList<RelationWithDepositor>()
            val db = this.readableDatabase
            val _cursor = db.query(RELATIONSHIP_WITH_DEPOSITOR_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                val _data = RelationWithDepositor()
                _data.relation = _cursor.getString(_cursor.getColumnIndex(RELATIONSHIP_WITH_DEPOSITOR_COLUMN_NAME))
                _data.relationCode = _cursor.getString(_cursor.getColumnIndex(RELATIONSHIP_WITH_DEPOSITOR_CODE_COLUMN_NAME))
                _array_list.add(_data)
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    val guardianRelationWithMinor: ArrayList<GuardianRelationWithMinor>
        get() {
            val _array_list = ArrayList<GuardianRelationWithMinor>()
            val db = this.readableDatabase
            val _cursor = db.query(GUARDIAN_RELATION_WITH_MINOR_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (!_cursor.isAfterLast) {
                val _data = GuardianRelationWithMinor()
                _data.relation = _cursor.getString(_cursor.getColumnIndex(GUARDIAN_RELATION_WITH_MINOR_COLUMN_NAME))
                _data.relationCode = _cursor.getString(_cursor.getColumnIndex(GUARDIAN_RELATION_WITH_MINOR_CODE_COLUMN_NAME))
                _array_list.add(_data)
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    val nomineeRelationWithDepositor: ArrayList<NomineeRelationWithDepositor>
        get() {
            val _array_list = ArrayList<NomineeRelationWithDepositor>()
            val db = this.readableDatabase
            val _cursor = db.query(NOMINEE_RELATIONSHIP_WITH_DEPOSITOR_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (!_cursor.isAfterLast) {
                val _data = NomineeRelationWithDepositor()
                _data.relation = _cursor.getString(_cursor.getColumnIndex(NOMINEE_RELATIONSHIP_WITH_DEPOSITOR_COLUMN_NAME))
                _data.relationCode = _cursor.getString(_cursor.getColumnIndex(NOMINEE_RELATIONSHIP_WITH_DEPOSITOR_CODE_COLUMN_NAME))
                _array_list.add(_data)
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val relationWithMinor: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(RELATIONSHIP_WITH_MINOR_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(RELATIONSHIP_WITH_MINOR_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val depositorType: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(DEPOSITOR_TYPE_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(DEPOSITOR_TYPE_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val tradingPreferance: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(TRADING_PREFERANCE_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(TRADING_PREFERANCE_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val tariffPlain: ArrayList<String>
        get() {
            val _array_list = ArrayList<String>()
            val db = this.readableDatabase
            val _cursor = db.query(TARIFF_PLAIN_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                _array_list.add(_cursor.getString(_cursor.getColumnIndex(TARIFF_PLAIN_COLUMN_NAME)))
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val foreignCity: ArrayList<String>
        get() {
            val array_list = ArrayList<String>()
            val db = this.readableDatabase
            val res = db.query(BIRTH_CITY_TABLE_NAME, null, null, null, null, null, null)
            res.moveToFirst()

            while (res.isAfterLast == false) {
                array_list.add(res.getString(res.getColumnIndex(BIRTH_CITY_COLUMN_NAME)))
                res.moveToNext()
            }
            res.close()
            return array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val foreignCityCount: Int
        get() {
            val db = this.readableDatabase
            val res = db.query(BIRTH_CITY_TABLE_NAME, null, null, null, null, null, null)
            val _ret = res.count
            res.close()
            return _ret
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val foreignCountry: ArrayList<String>
        get() {
            val array_list = ArrayList<String>()
            val db = this.readableDatabase
            val res = db.query(BIRTH_COUNTRY_TABLE_NAME, null, null, null, null, null, null)
            res.moveToFirst()

            while (res.isAfterLast == false) {
                array_list.add(res.getString(res.getColumnIndex(BIRTH_COUNTRY_COLUMN_NAME)))
                res.moveToNext()
            }
            res.close()
            return array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val foreignCountryCount: Int
        get() {
            val db = this.readableDatabase
            val res = db.query(BIRTH_COUNTRY_TABLE_NAME, null, null, null, null, null, null)
            val _ret = res.count
            res.close()
            return _ret
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val nsdl: ArrayList<String>
        get() {
            val array_list = ArrayList<String>()
            val db = this.readableDatabase
            val cursor = db.query(NSDL_TABLE_NAME, null, null, null, null, null, null)
            cursor.moveToFirst()
            while (cursor.isAfterLast == false) {
                array_list.add(cursor.getString(cursor.getColumnIndex(NSDL_BRANCH_COLUMN_NAME)).trim { it <= ' ' })
                cursor.moveToNext()
            }
            cursor.close()
            return array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val nsdlCount: Int
        get() {
            val db = this.readableDatabase
            val res = db.query(NSDL_TABLE_NAME, null, null, null, null, null, null)
            val _ret = res.count
            res.close()
            return _ret
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    //            count++;
    val csdl: ArrayList<String>
        get() {
            val array_list = ArrayList<String>()
            val db = this.readableDatabase
            val cursor = db.query(CSDL_TABLE_NAME, null, null, null, null, null, null)
            cursor.moveToFirst()
            while (cursor.isAfterLast == false) {
                array_list.add(cursor.getString(cursor.getColumnIndex(CSDL_BRANCH_COLUMN_NAME)).trim { it <= ' ' })
                cursor.moveToNext()
            }
            cursor.close()
            return array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val stateMaster: ArrayList<StateMasterData>
        get() {
            val _array_list = ArrayList<StateMasterData>()
            val db = this.readableDatabase
            val _cursor = db.query(STATE_TABLE_NAME, null, null, null, null, null, null)
            _cursor.moveToFirst()
            while (_cursor.isAfterLast == false) {
                val _data = StateMasterData()
                _data.stateName = _cursor.getString(_cursor.getColumnIndex(STATE_NAME_COLUMN_NAME))
                _data.stateCode = _cursor.getString(_cursor.getColumnIndex(STATE_CODE_COLUMN_NAME))
                _array_list.add(_data)
                _cursor.moveToNext()
            }
            _cursor.close()
            return _array_list
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val csdlCount: Int
        get() {
            val db = this.readableDatabase
            val res = db.query(CSDL_TABLE_NAME, null, null, null, null, null, null)
            val _ret = res.count
            res.close()
            return _ret
        }

    /**
     * Created by Gautam Anand
     * get session row
     * @return
     */
    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val sessionFormId: String
        get() {
            val db = this.readableDatabase
            val res = db.query(SESSION_TABLE_NAME, null, null, null, null, null, null)
            res.moveToFirst()
            val _formId = res.getString(res.getColumnIndex(MyDBHelper.SESSION_COLUMN_FORM_ID))
            res.close()
            return _formId
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    //UtilityClass.appendLog(ex.getMessage());
    val sessionToken: String
        get() {
            try {
                val db = this.readableDatabase
                val res = db.query(SESSION_TABLE_NAME, null, null, null, null, null, null)
                res.moveToFirst()
                val _token = res.getString(res.getColumnIndex(MyDBHelper.SESSION_COLUMN_KEY))
                res.close()
                return _token
            } catch (ex: Exception) {
            }

            return ""
        }

    //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
    val session: Cursor
        get() {
            val db = this.writableDatabase
            return db.query(SESSION_TABLE_NAME, null, null, null, null, null, null)
        }

    init {
        this.context = context
    }

    /**
     * Created by Gautam Anand
     * Called if the db is not present
     *
     * @param db
     */
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table $SESSION_TABLE_NAME(primaryid integer primary key, id text, sessionkey text, formid text)")
        db.execSQL("create table $APPLICANT_PREFIX_TABLE_NAME(primaryid integer primary key, prefix text)")
        db.execSQL("create table $ACCOUNT_TYPE_TABLE_NAME(primaryid integer primary key, accounttype text)")
        db.execSQL("create table $MARRIED_STATUS_TABLE_NAME(primaryid integer primary key, marriedstatustype text)")
        db.execSQL("create table $MALE_TITLE_TABLE_NAME(primaryid integer primary key, mtitle text)")
        db.execSQL("create table $FEMALE_TITLE_TABLE_NAME(primaryid integer primary key, ftitle text)")
        db.execSQL("create table $ANNUAL_INCOME_TABLE_NAME(primaryid integer primary key, income text)")
        db.execSQL("create table $SELF_ANNUAL_INCOME_TABLE_NAME(primaryid integer primary key, selfincome text)")
        db.execSQL("create table $ANNUAL_BUSINESS_TURNOVER_TABLE_NAME(primaryid integer primary key, income text)")
        db.execSQL("create table $RESIDENCE_TYPE_TABLE_NAME(primaryid integer primary key, type text)")
        db.execSQL("create table $EDUCATION_TABLE_NAME(primaryid integer primary key, educationtype text)")
        db.execSQL("create table $SOURCE_FUND_TABLE_NAME(primaryid integer primary key, source text)")
        db.execSQL("create table $SALARIED_TABLE_NAME(primaryid integer primary key, salarytype text)")
        db.execSQL("create table $ADDRESS_TYPE_TABLE_NAME(primaryid integer primary key, addresstype text)")
        db.execSQL("create table $RELATIONSHIP_WITH_DEPOSITOR_TABLE_NAME(primaryid integer primary key, relation text, relationcode text)")
        db.execSQL("create table $RELATIONSHIP_WITH_MINOR_TABLE_NAME(primaryid integer primary key, relation text)")
        db.execSQL("create table $NOMINEE_RELATIONSHIP_WITH_DEPOSITOR_TABLE_NAME(primaryid integer primary key, nomineerelation text, nomineerelationcode text)")
        db.execSQL("create table $DEPOSITOR_TYPE_TABLE_NAME(primaryid integer primary key, depositortype text)")
        db.execSQL("create table $GUARDIAN_RELATION_WITH_MINOR_TABLE_NAME(primaryid integer primary key, guardianrelation text, guardianrelationcode text)")
        db.execSQL("create table $TRADING_PREFERANCE_TABLE_NAME(primaryid integer primary key, trading text)")
        db.execSQL("create table $TARIFF_PLAIN_TABLE_NAME(primaryid integer primary key, traiffplain text)")
        db.execSQL("create table $BLOOD_GROUP_TABLE_NAME(primaryid integer primary key, grp text)")
        db.execSQL("create table $ILLNESS_TABLE_NAME(primaryid integer primary key, disease text)")
        db.execSQL("create table $CARD_HOLDER_TABLE_NAME(primaryid integer primary key, relationcardholder text)")
        db.execSQL("create table $SECURITIES_TABLE_NAME(primaryid integer primary key, securitiesname text)")
        db.execSQL("create table $NOMINEE_ADDRESS_PROOF_TABLE_NAME(primaryid integer primary key, addressproofname text)")
        db.execSQL("create table $MODE_RIGHTS_TABLE_NAME(primaryid integer primary key, moderightsname text)")
        db.execSQL("create table $SIP_DATE_TABLE_NAME(primaryid integer primary key, sipdate text)")
        db.execSQL("create table $PERIODS_TABLE_NAME(primaryid integer primary key, periodscolumn text)")
        db.execSQL("create table $PEP_HOLDER_TABLE_NAME(primaryid integer primary key, pepcolumn text)")
        db.execSQL("create table $BIRTH_CITY_TABLE_NAME(primaryid integer primary key, city text,code text)")
        db.execSQL("create table $BIRTH_COUNTRY_TABLE_NAME(primaryid integer primary key, country text,countrycode text)")
        db.execSQL("create table $NSDL_TABLE_NAME(primaryid integer primary key, solid text,branchid text)")
        db.execSQL("create table $CSDL_TABLE_NAME(primaryid integer primary key, solid text,branchid text)")
        db.execSQL("create table $STATE_TABLE_NAME(primaryid integer primary key, statename text,statecode text)")

        insertSalaried(db)
    }

    /**
     * Created by Gautam Anand
     * called when the database version is higher than the database version on db
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //To be used when db updates
    }

    // Custom on Boarding
    fun insertApplicantPrefix(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(APPLICANT_PREFIX_COLUMN_NAME, name)
        db.insert(APPLICANT_PREFIX_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteApplicantPrefix() {
        val db = this.writableDatabase
        db.execSQL("delete from " + APPLICANT_PREFIX_TABLE_NAME)
    }

    fun insertAccountType(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(ACCOUNT_TYPE_COLUMN_NAME, name)
        db.insert(ACCOUNT_TYPE_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteAccountType() {
        val db = this.writableDatabase
        db.execSQL("delete from " + ACCOUNT_TYPE_TABLE_NAME)
    }

    fun insertMarriedStatus(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(MARRIED_STATUS_COLUMN_NAME, name)
        db.insert(MARRIED_STATUS_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteMarriedStatus() {
        val db = this.writableDatabase
        db.execSQL("delete from " + MARRIED_STATUS_TABLE_NAME)
    }

    fun insertFemaleTitle(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(FEMALE_TITLE_COLUMN_NAME, name)
        db.insert(FEMALE_TITLE_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteFemaleTitle() {
        val db = this.writableDatabase
        db.execSQL("delete from " + FEMALE_TITLE_TABLE_NAME)
    }

    fun insertMaleTitle(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(MALE_TITLE_COLUMN_NAME, name)
        db.insert(MALE_TITLE_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteMaleTitle() {
        val db = this.writableDatabase
        db.execSQL("delete from " + MALE_TITLE_TABLE_NAME)
    }

    fun insertAnnualIncome(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(ANNUAL_INCOME_COLUMN_NAME, name)
        db.insert(ANNUAL_INCOME_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteAnnualIncome() {
        val db = this.writableDatabase
        db.execSQL("delete from " + ANNUAL_INCOME_TABLE_NAME)
    }

    fun insertSelfAnnualIncome(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(SELF_ANNUAL_INCOME_COLUMN_NAME, name)
        db.insert(SELF_ANNUAL_INCOME_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteSelfAnnualIncome() {
        val db = this.writableDatabase
        db.execSQL("delete from " + SELF_ANNUAL_INCOME_TABLE_NAME)
    }

    fun insertResidenceType(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(RESIDENCE_TYPE_COLUMN_NAME, name)
        db.insert(RESIDENCE_TYPE_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteResidenceType() {
        val db = this.writableDatabase
        db.execSQL("delete from " + RESIDENCE_TYPE_TABLE_NAME)
    }

    fun insertBloodGroup(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(BLOOD_GROUP_COLUMN_NAME, name)
        db.insert(BLOOD_GROUP_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteBloodGroup() {
        val db = this.writableDatabase
        db.execSQL("delete from " + BLOOD_GROUP_TABLE_NAME)
    }

    fun insertIllness(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(ILLNESS_GROUP_COLUMN_NAME, name)
        db.insert(ILLNESS_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteIllness() {
        val db = this.writableDatabase
        db.execSQL("delete from " + ILLNESS_TABLE_NAME)
    }

    fun insertRelationCardHolder(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(CARD_HOLDER_COLUMN_NAME, name)
        db.insert(CARD_HOLDER_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteRelationCardHolder() {
        val db = this.writableDatabase
        db.execSQL("delete from " + CARD_HOLDER_TABLE_NAME)
    }

    fun insertSecurities(name: String): Boolean {
        val db = this.readableDatabase
        val contentValues = ContentValues()
        contentValues.put(SECURITIES_NAME_COLUMN_NAME, name)
        db.insert(SECURITIES_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteSecurities() {
        val db = this.writableDatabase
        db.execSQL("delete from " + SECURITIES_TABLE_NAME)
    }

    fun insertAddressProof(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NOMINEE_ADDRESS_PROOF_COLUMN_NAME, name)
        db.insert(NOMINEE_ADDRESS_PROOF_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteAddressProof() {
        val db = this.writableDatabase
        db.execSQL("delete from " + NOMINEE_ADDRESS_PROOF_TABLE_NAME)
    }

    fun insertModeRights(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(MODE_RIGHTS_COLUMN_NAME, name)
        db.insert(MODE_RIGHTS_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteModeRights() {
        val db = this.writableDatabase
        db.execSQL("delete from " + MODE_RIGHTS_TABLE_NAME)
    }

    fun insertSipDate(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(SIP_DATE_COLUMN_NAME, name)
        db.insert(SIP_DATE_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteSipDate() {
        val db = this.writableDatabase
        db.execSQL("delete from " + SIP_DATE_TABLE_NAME)
    }

    fun insertPeriods(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(PERIODS_COLUMN_NAME, name)
        db.insert(PERIODS_TABLE_NAME, null, contentValues)
        return true
    }

    fun deletePeriods() {
        val db = this.writableDatabase
        db.execSQL("delete from " + PERIODS_TABLE_NAME)
    }

    fun insertPepHolder(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(PEP_HOLDER_COLUMN_NAME, name)
        db.insert(PEP_HOLDER_TABLE_NAME, null, contentValues)
        return true
    }

    fun deletePepHolder() {
        val db = this.writableDatabase
        db.execSQL("delete from " + PEP_HOLDER_TABLE_NAME)
    }

    fun insertEducation(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(EDUCATION_COLUMN_NAME, name)
        db.insert(EDUCATION_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteEducation() {
        val db = this.writableDatabase
        db.execSQL("delete from " + EDUCATION_TABLE_NAME)
    }

    fun insertSourceofFunds(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(SOURCE_FUND_COLUMN_NAME, name)
        db.insert(SOURCE_FUND_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteSourceofFunds() {
        val db = this.writableDatabase
        db.execSQL("delete from " + SOURCE_FUND_TABLE_NAME)
    }

    fun insertSalaried(db: SQLiteDatabase): Boolean {
        //SQLiteDatabase db = this.getReadableDatabase();
        val _inputData = ArrayList<String>()
        _inputData.add("YES")
        _inputData.add("NO")

        var _return = 0L
        for (input in _inputData) {
            try {
                val contentValues = ContentValues()
                contentValues.put(SALARIED_COLUMN_NAME, input)
                _return = db.insertOrThrow(SALARIED_TABLE_NAME, null, contentValues)
            } catch (ex: Exception) {
                //ex.printStackTrace();
            }

        }

        return if (_return == 0L) {
            false
        } else {
            true
        }
    }

    fun insertAnnualBusinessTurnover(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(ANNUAL_BUSINESS_TURNOVER_INCOME_COLUMN_NAME, name)
        db.insert(ANNUAL_BUSINESS_TURNOVER_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteAnnualBusinessTurnover() {
        val db = this.writableDatabase
        db.execSQL("delete from " + ANNUAL_BUSINESS_TURNOVER_TABLE_NAME)
    }

    fun insertAddressType(name: String): Boolean {
        val db = this.readableDatabase
        val contentValues = ContentValues()
        contentValues.put(ADDRESS_TYPE_COLUMN_NAME, name)
        db.insert(ADDRESS_TYPE_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteAddressType() {
        val db = this.writableDatabase
        db.execSQL("delete from " + ADDRESS_TYPE_TABLE_NAME)
    }

    inner class RelationWithDepositor {
        var relation: String? = null
        var relationCode: String? = null
    }

    //Nominee Details
    fun insertRelationWithDepositor(name: String, code: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(RELATIONSHIP_WITH_DEPOSITOR_COLUMN_NAME, name)
        contentValues.put(RELATIONSHIP_WITH_DEPOSITOR_CODE_COLUMN_NAME, code)
        db.insertOrThrow(RELATIONSHIP_WITH_DEPOSITOR_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteRelationWithDepositor() {
        val db = this.writableDatabase
        db.execSQL("delete from " + RELATIONSHIP_WITH_DEPOSITOR_TABLE_NAME)
    }

    inner class GuardianRelationWithMinor {
        var relation: String? = null
        var relationCode: String? = null
    }

    fun insertGuardianRelationWithMinor(name: String, code: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(GUARDIAN_RELATION_WITH_MINOR_COLUMN_NAME, name)
        contentValues.put(GUARDIAN_RELATION_WITH_MINOR_CODE_COLUMN_NAME, code)
        db.insert(GUARDIAN_RELATION_WITH_MINOR_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteGuardianRelationWithMinor() {
        val db = this.writableDatabase
        db.execSQL("delete from " + GUARDIAN_RELATION_WITH_MINOR_TABLE_NAME)
    }

    inner class NomineeRelationWithDepositor {
        var relation: String? = null
        var relationCode: String? = null
    }

    fun insertNomiRelationWithDepositor(name: String, code: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NOMINEE_RELATIONSHIP_WITH_DEPOSITOR_COLUMN_NAME, name)
        contentValues.put(NOMINEE_RELATIONSHIP_WITH_DEPOSITOR_CODE_COLUMN_NAME, code)
        db.insert(NOMINEE_RELATIONSHIP_WITH_DEPOSITOR_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteNomiRelationWithDepositor() {
        val db = this.writableDatabase
        db.execSQL("delete from " + NOMINEE_RELATIONSHIP_WITH_DEPOSITOR_TABLE_NAME)
    }

    fun insertRelationWithMinor(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(RELATIONSHIP_WITH_MINOR_COLUMN_NAME, name)
        db.insert(RELATIONSHIP_WITH_MINOR_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteRelationWithMinor() {
        val db = this.writableDatabase
        db.execSQL("delete from " + RELATIONSHIP_WITH_MINOR_TABLE_NAME)
    }

    //Demat Trading
    fun insertDepositorType(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(DEPOSITOR_TYPE_COLUMN_NAME, name)
        db.insert(DEPOSITOR_TYPE_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteDepositorType() {
        val db = this.writableDatabase
        db.execSQL("delete from " + DEPOSITOR_TYPE_TABLE_NAME)
    }

    fun insertTradingPreferance(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(TRADING_PREFERANCE_COLUMN_NAME, name)
        db.insert(TRADING_PREFERANCE_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteTradingPreferance() {
        val db = this.writableDatabase
        db.execSQL("delete from " + TRADING_PREFERANCE_TABLE_NAME)
    }

    fun insertTariffPlan(name: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(TARIFF_PLAIN_COLUMN_NAME, name)
        db.insert(TARIFF_PLAIN_TABLE_NAME, null, contentValues)
        return true
    }

    fun deleteTariffPlan() {
        val db = this.writableDatabase
        db.execSQL("delete from " + TARIFF_PLAIN_TABLE_NAME)
    }

    fun insertForeignCity(cityName: String, cityCode: String): Boolean {
        //SQLiteDatabase db = this.getWritableDatabase(ConstantStrings.DB_KEY);
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(BIRTH_CITY_COLUMN_NAME, cityName)
        contentValues.put(BIRTH_CITY_CODE_COLUMN_NAME, cityCode)
        db.insert(BIRTH_CITY_TABLE_NAME, null, contentValues)
        return true
    }

    fun insertForeignCountry(countryName: String, countryCode: String): Boolean {
        //SQLiteDatabase db = this.getWritableDatabase(ConstantStrings.DB_KEY);
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(BIRTH_COUNTRY_COLUMN_NAME, countryName)
        contentValues.put(BIRTH_COUNTRY_CODE_COLUMN_NAME, countryCode)
        db.insert(BIRTH_COUNTRY_TABLE_NAME, null, contentValues)

        return true
    }

    fun insertNSDL(solId: String, branchId: String): Boolean {
        //SQLiteDatabase db = this.getWritableDatabase(ConstantStrings.DB_KEY);
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NSDL_SOLID_COLUMN_NAME, solId.trim { it <= ' ' })
        contentValues.put(NSDL_BRANCH_COLUMN_NAME, branchId.trim { it <= ' ' })
        db.insert(NSDL_TABLE_NAME, null, contentValues)
        return true
    }

    fun getNSDLSolId(_solId: String): String {
        //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
        val db = this.readableDatabase
        //        String res = db.query("SELECT" + NSDL_SOLID_COLUMN_NAME + "FROM" + NSDL_TABLE_NAME + "WHERE" + NSDL_BRANCH_COLUMN_NAME + "=" + _solId);
        //        String _query = "SELECT " + NSDL_SOLID_COLUMN_NAME + " FROM " + NSDL_TABLE_NAME + " WHERE " + NSDL_BRANCH_COLUMN_NAME + " = " + _solId;
        val _colToReturn = arrayOf("*")
        val _selection = "branchid =?"
        val _selectionArgs = arrayOf(_solId)
        val res = db.query(NSDL_TABLE_NAME, _colToReturn, _selection, _selectionArgs, null, null, null)
        /*String _query = "SELECT * FROM " + NSDL_TABLE_NAME + " WHERE " + NSDL_BRANCH_COLUMN_NAME + " = " + _solId;
        Cursor res = db.query(_query, null, null, null, null, null, null);*/
        res.moveToFirst()
        val _return = res.getString(res.getColumnIndex(NSDL_SOLID_COLUMN_NAME)).trim { it <= ' ' }
        res.close()
        return _return
    }

    fun insertCSDL(solId: String, branchId: String): Boolean {
        //SQLiteDatabase db = this.getWritableDatabase(ConstantStrings.DB_KEY);
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(CSDL_SOLID_COLUMN_NAME, solId.trim { it <= ' ' })
        contentValues.put(CSDL_BRANCH_COLUMN_NAME, branchId.trim { it <= ' ' })
        db.insert(CSDL_TABLE_NAME, null, contentValues)
        return true
    }

    inner class StateMasterData {
        var stateName: String? = null
        var stateCode: String? = null
    }

    fun insertStateMaster(stateName: String, stateCode: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(STATE_NAME_COLUMN_NAME, stateName.trim { it <= ' ' })
        contentValues.put(STATE_CODE_COLUMN_NAME, stateCode.trim { it <= ' ' })
        db.insert(STATE_TABLE_NAME, null, contentValues)
        return true
    }

    fun getCDSLSolId(_solId: String): String {
        //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
        val db = this.readableDatabase
        //        String res = db.query("SELECT" + NSDL_SOLID_COLUMN_NAME + "FROM" + NSDL_TABLE_NAME + "WHERE" + NSDL_BRANCH_COLUMN_NAME + "=" + _solId);
        //        String _query = "SELECT " + NSDL_SOLID_COLUMN_NAME + " FROM " + NSDL_TABLE_NAME + " WHERE " + NSDL_BRANCH_COLUMN_NAME + " = " + _solId;
        val _colToReturn = arrayOf("*")
        val _selection = "branchid =?"
        val _selectionArgs = arrayOf(_solId)
        val res = db.query(CSDL_TABLE_NAME, _colToReturn, _selection, _selectionArgs, null, null, null)
        /*String _query = "SELECT * FROM " + NSDL_TABLE_NAME + " WHERE " + NSDL_BRANCH_COLUMN_NAME + " = " + _solId;
        Cursor res = db.query(_query, null, null, null, null, null, null);*/
        res.moveToFirst()
        val _return = res.getString(res.getColumnIndex(CSDL_SOLID_COLUMN_NAME)).trim { it <= ' ' }
        res.close()
        return _return
    }

    fun getLastSync(id: String): String {
        val db = this.writableDatabase
        val _colToReturn = arrayOf("" + "lastsync" + "")
        val _selection = "id" + " =?"
        val _selectionArgs = arrayOf("" + id + "")

        val _res1 = db.query(SESSION_TABLE_NAME, null, null, null, null, null, null)

        _res1.moveToFirst()
        val _count = _res1.count
        if (_count == 0) {
            _res1.close()
            return "0"
        } else {
            return "0"
        }
    }

    fun updateLastSync(id: String, lastSync: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(SESSION_COLUMN_LAST_SYNC, lastSync)
        db.update(SESSION_TABLE_NAME, contentValues, "id = ?", arrayOf(id))
    }

    fun deleteSession() {
        //SQLiteDatabase db = this.getWritableDatabase(ConstantStrings.DB_KEY);
        val db = this.writableDatabase
        db.execSQL("delete from " + SESSION_TABLE_NAME)
    }

    fun deleteCDSL() {
        //SQLiteDatabase db = this.getWritableDatabase(ConstantStrings.DB_KEY);
        val db = this.writableDatabase
        db.execSQL("delete from " + CSDL_TABLE_NAME)
    }

    fun deleteNSDL() {
        //SQLiteDatabase db = this.getWritableDatabase(ConstantStrings.DB_KEY);
        val db = this.writableDatabase
        db.execSQL("delete from " + NSDL_TABLE_NAME)
    }

    /**
     * Created by Gautam Anand
     * insert session row
     * @param id
     * @param key
     * @param formId
     * @return
     */
    fun insertSession(id: String, key: String, formId: String/*, String lastSync*/): Boolean {
        //SQLiteDatabase db = this.getWritableDatabase(ConstantStrings.DB_KEY);
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(SESSION_COLUMN_ID, id)
        contentValues.put(SESSION_COLUMN_KEY, key)
        contentValues.put(SESSION_COLUMN_FORM_ID, formId)
        //        contentValues.put(SESSION_COLUMN_LAST_SYNC, lastSync);
        deleteSession()
        db.insert(SESSION_TABLE_NAME, null, contentValues)
        return true
    }

    /**
     * Created by Gautam Anand
     * update session row
     * @param id
     * @param key
     * @param formId
     * @return
     */
    fun updateSession(id: String, key: String, formId: String): Boolean {
        var formId = formId
        if (formId == "") {
            val _cursor = session
            _cursor.moveToFirst()
            val _formId = _cursor.getString(_cursor.getColumnIndex(MyDBHelper.SESSION_COLUMN_FORM_ID))
            if (_formId != null) {
                formId = _formId
            }
            _cursor.close()
        }

        //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
        val db = this.readableDatabase
        val contentValues = ContentValues()
        contentValues.put(SESSION_COLUMN_KEY, key)
        contentValues.put(SESSION_COLUMN_FORM_ID, formId)
        try {
            db.update(SESSION_TABLE_NAME, contentValues, "id = ? ", arrayOf(id))
        } catch (ex: Exception) {
            //ex.printStackTrace();
        }

        return true
    }

    /**
     * Created by Gautam Anand
     * get row data from given table
     * @param id
     * @param tableName
     * @return
     */
    fun getData(id: Int, tableName: String): Cursor {
        //SQLiteDatabase db = this.getReadableDatabase(ConstantStrings.DB_KEY);
        val db = this.readableDatabase
        //        Cursor res = db.rawQuery("select * from " + tableName + " where id=" + id + "", null);
        val _selection = "id =?"
        val _selectionArgs = arrayOf(id.toString())
        return db.query(tableName, null, _selection, _selectionArgs, null, null, null)
    }

    companion object {
        // local DB name
        val DATABASE_NAME = "TIOApp.db"

        // below are the table and column name Identifiers
        val SESSION_TABLE_NAME = "session"
        val SESSION_COLUMN_ID = "id"
        val SESSION_COLUMN_KEY = "sessionkey"
        val SESSION_COLUMN_FORM_ID = "formid"
        val SESSION_COLUMN_LAST_SYNC = "lastsync"

        val APPLICANT_PREFIX_TABLE_NAME = "applicatprefix"
        val APPLICANT_PREFIX_COLUMN_NAME = "prefix"

        val ACCOUNT_TYPE_TABLE_NAME = "account"
        val ACCOUNT_TYPE_COLUMN_NAME = "accounttype"

        val MARRIED_STATUS_TABLE_NAME = "statusofmarried"
        val MARRIED_STATUS_COLUMN_NAME = "marriedstatustype"

        val MALE_TITLE_TABLE_NAME = "maletitle"
        val MALE_TITLE_COLUMN_NAME = "mtitle"

        val FEMALE_TITLE_TABLE_NAME = "femaletitle"
        val FEMALE_TITLE_COLUMN_NAME = "ftitle"

        val ANNUAL_INCOME_TABLE_NAME = "annualincome"
        val ANNUAL_INCOME_COLUMN_NAME = "income"

        val SELF_ANNUAL_INCOME_TABLE_NAME = "selfannualincome"
        val SELF_ANNUAL_INCOME_COLUMN_NAME = "selfincome"

        val ANNUAL_BUSINESS_TURNOVER_TABLE_NAME = "annualbusinessturnover"
        val ANNUAL_BUSINESS_TURNOVER_INCOME_COLUMN_NAME = "income"

        val RESIDENCE_TYPE_TABLE_NAME = "residencetype"
        val RESIDENCE_TYPE_COLUMN_NAME = "type"

        val EDUCATION_TABLE_NAME = "education"
        val EDUCATION_COLUMN_NAME = "educationtype"

        val SOURCE_FUND_TABLE_NAME = "sorceoffund"
        val SOURCE_FUND_COLUMN_NAME = "source"

        val SALARIED_TABLE_NAME = "salary"
        val SALARIED_COLUMN_NAME = "salarytype"

        val ADDRESS_TYPE_TABLE_NAME = "address"
        val ADDRESS_TYPE_COLUMN_NAME = "addresstype"

        val RELATIONSHIP_WITH_DEPOSITOR_TABLE_NAME = "relationwithdepositor"
        val RELATIONSHIP_WITH_DEPOSITOR_COLUMN_NAME = "relation"
        val RELATIONSHIP_WITH_DEPOSITOR_CODE_COLUMN_NAME = "relationcode"

        val RELATIONSHIP_WITH_MINOR_TABLE_NAME = "relationwithminor"
        val RELATIONSHIP_WITH_MINOR_COLUMN_NAME = "relation"

        val NOMINEE_RELATIONSHIP_WITH_DEPOSITOR_TABLE_NAME = "nomineerelationwithminor"
        val NOMINEE_RELATIONSHIP_WITH_DEPOSITOR_COLUMN_NAME = "nomineerelation"
        val NOMINEE_RELATIONSHIP_WITH_DEPOSITOR_CODE_COLUMN_NAME = "nomineerelationcode"

        val GUARDIAN_RELATION_WITH_MINOR_TABLE_NAME = "guardianrelationwithminor"
        val GUARDIAN_RELATION_WITH_MINOR_COLUMN_NAME = "guardianrelation"
        val GUARDIAN_RELATION_WITH_MINOR_CODE_COLUMN_NAME = "guardianrelationcode"

        val DEPOSITOR_TYPE_TABLE_NAME = "depositor"
        val DEPOSITOR_TYPE_COLUMN_NAME = "depositortype"

        val TRADING_PREFERANCE_TABLE_NAME = "tradingprefferance"
        val TRADING_PREFERANCE_COLUMN_NAME = "trading"

        val TARIFF_PLAIN_TABLE_NAME = "traiff"
        val TARIFF_PLAIN_COLUMN_NAME = "traiffplain"

        val BLOOD_GROUP_TABLE_NAME = "bloodgroup"
        val BLOOD_GROUP_COLUMN_NAME = "grp"

        val ILLNESS_TABLE_NAME = "illness"
        val ILLNESS_GROUP_COLUMN_NAME = "disease"

        val CARD_HOLDER_TABLE_NAME = "cardholder"
        val CARD_HOLDER_COLUMN_NAME = "relationcardholder"

        val BIRTH_CITY_TABLE_NAME = "foreigncity"
        val BIRTH_CITY_COLUMN_NAME = "city"
        val BIRTH_CITY_CODE_COLUMN_NAME = "code"

        val BIRTH_COUNTRY_TABLE_NAME = "foreigncountry"
        val BIRTH_COUNTRY_COLUMN_NAME = "country"
        val BIRTH_COUNTRY_CODE_COLUMN_NAME = "countrycode"

        val NSDL_TABLE_NAME = "nsdl"
        val NSDL_SOLID_COLUMN_NAME = "solid"
        val NSDL_BRANCH_COLUMN_NAME = "branchid"

        val CSDL_TABLE_NAME = "csdl"
        val CSDL_SOLID_COLUMN_NAME = "solid"
        val CSDL_BRANCH_COLUMN_NAME = "branchid"

        val SECURITIES_TABLE_NAME = "securities"
        val SECURITIES_NAME_COLUMN_NAME = "securitiesname"

        val NOMINEE_ADDRESS_PROOF_TABLE_NAME = "nomineeaddressproof"
        val NOMINEE_ADDRESS_PROOF_COLUMN_NAME = "addressproofname"

        val MODE_RIGHTS_TABLE_NAME = "moderights"
        val MODE_RIGHTS_COLUMN_NAME = "moderightsname"

        val SIP_DATE_TABLE_NAME = "sip"
        val SIP_DATE_COLUMN_NAME = "sipdate"

        val PERIODS_TABLE_NAME = "periods"
        val PERIODS_COLUMN_NAME = "periodscolumn"

        val PEP_HOLDER_TABLE_NAME = "pep"
        val PEP_HOLDER_COLUMN_NAME = "pepcolumn"

        val STATE_TABLE_NAME = "state"
        val STATE_NAME_COLUMN_NAME = "statename"
        val STATE_CODE_COLUMN_NAME = "statecode"

        val KEY_TABLE_NAME = "key"

        private var instance: MyDBHelper? = null

        //database version
        val DATABASE_VERSION = 1

        /**
         * Created by Gautam Anand
         *
         * @param context
         * @return
         */
        @Synchronized
        fun getInstance(context: Context): MyDBHelper {
            if (instance == null) {
                //SQLiteDatabase.loadLibs(context);
                instance = MyDBHelper(context)
            }
            return instance as MyDBHelper
        }
    }
}

