#pragma once

template < typename T>
class CTmpArr
{
private:
	T* m_pData;
	bool* m_pAdded;
	int m_iCount;


public:
	CTmpArr(void):m_pData(NULL), m_pAdded(NULL), m_iCount(0){}
	~CTmpArr(void) {
		Release(&m_pData);
		Release(&m_pAdded);
	}
	CTmpArr(int _cnt)
	{
		m_pData = new T[_cnt];
		m_pAdded = new bool[_cnt];
		memset(m_pAdded, 0, sizeof(bool) * _cnt);
		m_iCount = _cnt;
	}

	///<summary>
	//���� �˻� �Ͽ� ����� �����͸� Setting ����� ������ ������ �ø���
	///</summary>
	void Add(T _data)
	{
		for (int i = 0; i < m_iCount; ++i)
		{
			if (!Is_Added(i))
			{
				m_pAdded[i] = true;
				m_pData[i] = _data;
				return;
			}
		}
		m_iCount += 1;
		T* pNewData = new T[m_iCount];
		bool* pNewAdded = new bool[m_iCount];
		
		memset(pNewAdded, 0, sizeof(bool) * m_iCount);

		memcpy(pNewData, m_pData, sizeof(T) * (m_iCount - 1));
		memcpy(pNewAdded, m_pAdded, sizeof(bool) * (m_iCount - 1));

		Release(&m_pData);
		Release(&m_pAdded);
		
		m_pData = pNewData;
		m_pAdded = pNewAdded;

		m_pData[m_iCount - 1] = _data;
		m_pAdded[m_iCount - 1] = true;
	}
	///<summary>
	//�ش� �ε����� �Ҵ�� ������ �ƴϸ� ������ �ø���(÷�� ���� �߰�) Index Ver.
	///</summary>
	void Add(T _data, int _idx)
	{
		if (IsIn_Range(_idx))
		{
			m_pAdded[_idx] = true;
			m_pData[_idx] = _data;
		}
		else
		{
			int size = _idx + 1;
			T* pNewData = new T[size];
			bool* pNewAdded = new bool[size];

			memset(pNewAdded, 0, sizeof(bool) * size);

			memcpy(pNewData, m_pData, sizeof(T) * (m_iCount));
			memcpy(pNewAdded, m_pAdded, sizeof(bool) * (m_iCount));

			m_iCount = size;

			Release(&m_pData);
			Release(&m_pAdded);

			m_pData = pNewData;
			m_pAdded = pNewAdded;

			m_pData[_idx] = _data;
			m_pAdded[_idx] = true;
		}
		
	}

	///<summary>
	//������ ���� ������� �迭�� ũ��� �״��
	///</summary>
	void Remove(int _idx)
	{
		m_pData[_idx] = NULL;
		m_pAdded[_idx] = false;
	}

	///<summary>
	// �迭�� ������ Set
	///</summary>
	void SetData(int _idx, T _data)
	{
		m_pData[_idx] = _data;
		m_pAdded[_idx] = true;
	}

	///<summary>
	// ������ Get
	///</summary>
	T GetData(int _idx)
	{
		//��ǻ� ���߶������ ����ó��
		/*if(!IsIn_Range(_idx))
			return NULL;*/
		if (!Is_Added(_idx))
			return NULL;

		return *(m_pData + _idx);
			
		//������ ���ϱ� ����
		//return *(m_pData + _idx);
		
		//���������� ���
		/*T* pTmp = pHead;
		for (int i = 0; i < _idx; ++i)
		++pTmp;

		return *pTmp;*/

		//pHead�� ���̵� �����Ͷ�� �̷���
		/*return *(pHead + (sizeof(T)* _idx));*/
	}

	///<summary>
	// ���� �ٲٱ�
	///</summary>
	void Swap(int idx_1, int idx_2)
	{
		if (!IsIn_Range(idx_1))
			return;
		if (!IsIn_Range(idx_2))
			return;

		T data = *(m_pData + idx_1);
		*(m_pData + idx_1) = *(m_pData + idx_2);
		*(m_pData + idx_2) = data;
	}

	///<summary>
	// �迭 ũ�� ��ȯ
	///</summary>
	int Size()
	{
		return m_iCount;
	}

	///<summary>
	// ������ �ִ��� �˻�
	///</summary>
	int Find(T _data)
	{
		for (int i = 0; i < m_iCount; ++i)
		{
			if (!Is_Added(idx))
				continue;
			if (m_pData[i] == _data)
				return i;
		}
		return -1;
	}
	
	bool IsIn_Range(int _idx)
	{
		if (_idx > m_iCount - 1 || _idx < 0)
			return false;
		else
			return true;
	}
	bool Is_Added(int _idx)
	{
		if (!IsIn_Range(_idx))
			return false;
		return m_pAdded[_idx];
	}

	template < typename TT>
	bool Release(TT** _p)
	{
		if (*_p != NULL)
		{
			delete *_p;
			*_p = NULL;
			return true;
		}
		return false;
	}

};