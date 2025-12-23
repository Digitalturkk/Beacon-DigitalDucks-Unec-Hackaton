import { Area, AreaChart, CartesianGrid, ResponsiveContainer, Tooltip } from 'recharts';

export default function ProgressChart({ data }) {
  return (
    <ResponsiveContainer width="100%" height="100%">
      <AreaChart data={data} margin={{ top: 10, right: 10, left: -20, bottom: 0 }}>
        <defs>
          <linearGradient id="progressGradient" x1="0" y1="0" x2="0" y2="1">
            <stop offset="0%" stopColor="#6a8bff" stopOpacity={0.65} />
            <stop offset="100%" stopColor="#7dd6ff" stopOpacity={0.2} />
          </linearGradient>
        </defs>
        <CartesianGrid stroke="rgba(15,25,46,0.08)" vertical={false} />
        <Tooltip
          contentStyle={{
            background: '#ffffff',
            border: '1px solid rgba(15,25,46,0.08)',
            borderRadius: 10,
            color: '#0f1a2e'
          }}
        />
        <Area
          type="monotone"
          dataKey="value"
          stroke="#5573ff"
          strokeWidth={3}
          fill="url(#progressGradient)"
          dot={{ r: 4, fill: '#35b7ff', strokeWidth: 0 }}
          activeDot={{ r: 6, stroke: '#fff', strokeWidth: 2, fill: '#5573ff' }}
        />
      </AreaChart>
    </ResponsiveContainer>
  );
}

